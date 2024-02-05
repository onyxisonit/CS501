package com.example.simplecalculatorapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.View
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

// referenced ChatGPT to learn more about it and how it refers to the View
// that triggered the click event to access properties or perform actions related to the View event
        addButton.setOnClickListener { performOperation(it) }
        subButton.setOnClickListener { performOperation(it)}
        mulButton.setOnClickListener { performOperation(it) }
        divButton.setOnClickListener { performOperation(it) }
        modButton.setOnClickListener { performOperation(it) }
    }

    private fun performOperation(view: View) {
        if (op1.text.isNotEmpty() && op2.text.isNotEmpty()) {
            num1 = op1.text.toString().toFloat()
            num2 = op2.text.toString().toFloat()

//            referenced ChatGPT/ Google/ Kotlin Documentation to figure out the Kotlin equivalent of C's switch
//             got inspo from below:
//            when (view.id) {
//                R.id.add_button -> output.text = (num1 + num2).toString()
//                R.id.sub_button -> output.text = (num1 - num2).toString()
//                R.id.mul_button -> output.text = (num1 * num2).toString()
//                R.id.div_button -> output.text = if (num2 != 0.0.toFloat()) (num1 / num2).toString() else "Cannot divide by zero"
//                R.id.mod_button -> output.text = if (num2 != 0.0.toFloat()) (num1 % num2).toString() else "Cannot calculate modulo by zero"
//            }
            when (view.id) {
                R.id.add_button -> output.text = (num1 + num2).toString()
                R.id.sub_button -> output.text = (num1 - num2).toString()
                R.id.mul_button -> output.text = (num1 * num2).toString()
                R.id.div_button -> output.text = if (num2 != 0.0.toFloat()) (num1 / num2).toString() else "Cannot divide by zero"
                R.id.mod_button -> output.text = if (num2 != 0.0.toFloat()) (num1 % num2).toString() else "Cannot calculate modulo by zero"
            }

        } else {
            output.text = "Please enter both operands."
        }
    }

}
