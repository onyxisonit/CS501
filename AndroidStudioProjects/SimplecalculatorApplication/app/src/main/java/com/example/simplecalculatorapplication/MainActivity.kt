package com.example.simplecalculatorapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var addButton: Button
    private lateinit var subButton: Button
    private lateinit var mulButton: Button
    private lateinit var divButton: Button
    private lateinit var modButton: Button
    private lateinit var op1: EditText
    private lateinit var op2: EditText
    private lateinit var output: TextView

    private var num1: Float = 0.0.toFloat()
    private var num2: Float = 0.0.toFloat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton = findViewById(R.id.add_button)
        subButton = findViewById(R.id.sub_button)
        mulButton = findViewById(R.id.mul_button)
        divButton = findViewById(R.id.div_button)
        modButton = findViewById(R.id.mod_button)
        op1 = findViewById<EditText>(R.id.operand1)
        op2 = findViewById<EditText>(R.id.operand2)
        output = findViewById<TextView>(R.id.output)

        addButton.setOnClickListener { performOperation(Operation.ADD) }
        subButton.setOnClickListener { performOperation(Operation.SUBTRACT) }
        mulButton.setOnClickListener { performOperation(Operation.MULTIPLY) }
        divButton.setOnClickListener { performOperation(Operation.DIVIDE) }
        modButton.setOnClickListener { performOperation(Operation.MODULO) }
    }

    private fun performOperation(operation: Operation) {
        if (op1.text.isNotEmpty() && op2.text.isNotEmpty()) {
            num1 = op1.text.toString().toFloat()
            num2 = op2.text.toString().toFloat()

            when (operation) {
                Operation.ADD -> output.text = (num1 + num2).toString()
                Operation.SUBTRACT -> output.text = (num1 - num2).toString()
                Operation.MULTIPLY -> output.text = (num1 * num2).toString()
                Operation.DIVIDE -> output.text = if (num2 != 0.0.toFloat()) (num1 / num2).toString() else "Cannot divide by zero"
                Operation.MODULO -> output.text = if (num2 != 0.0.toFloat()) (num1 % num2).toString() else "Cannot calculate modulo by zero"
            }
        } else {
            output.text = "Please enter both operands."
        }
    }

    enum class Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, MODULO
    }
}

//import android.os.Bundle
//import android.view.View
//import android.widget.RadioButton
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        calculateButton.setOnClickListener {
//            calculate()
//        }
//    }
//
//    private fun calculate() {
//        try {
//            val operand1 = editTextOperand1.text.toString().toDouble()
//            val operand2 = editTextOperand2.text.toString().toDouble()
//
//            val result = when (getSelectedOperation()) {
//                R.id.radioButtonAddition -> operand1 + operand2
//                R.id.radioButtonSubtraction -> operand1 - operand2
//                R.id.radioButtonMultiplication -> operand1 * operand2
//                R.id.radioButtonDivision -> {
//                    if (operand2 != 0.0) {
//                        operand1 / operand2
//                    } else {
//                        showToast("Divide by Zero not allowed.")
//                        return
//                    }
//                }
//                R.id.radioButtonModulus -> {
//                    if (operand2 != 0.0) {
//                        operand1 % operand2
//                    } else {
//                        showToast("Modulus with zero not allowed.")
//                        return
//                    }
//                }
//                else -> throw IllegalArgumentException("Invalid operation selected")
//            }
//
//            textViewResult.text = "Result: $result"
//        } catch (e: NumberFormatException) {
//            showToast("Invalid Operand. Please enter valid numbers.")
//        }
//    }
//
//    private fun getSelectedOperation(): Int {
//        val selectedOperationId = radioGroupOperations.checkedRadioButtonId
//        if (selectedOperationId == -1) {
//            showToast("Please select an operation.")
//            throw IllegalStateException("No operation selected")
//        }
//
//        return selectedOperationId
//    }
//
//    private fun showToast(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    }
//}
