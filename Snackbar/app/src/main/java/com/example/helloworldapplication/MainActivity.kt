package com.example.helloworldapplication

import com.example.helloworldapplication.R
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button_id)
        val textView = findViewById<TextView>(R.id.textView_id)

//        button.setOnClickListener {
//            textView.text = getString(R.string.saying_hello)
//            button.text = getString(R.string.button_goodbye)
//        }
//
//        button.setOnClickListener {
//            textView.text = ""
//            button.text = getString(R.string.button_hello)
//        }
        button.setOnClickListener {
            if (button.text == getString(R.string.button_hello)) {
                textView.text = getString(R.string.saying_hello)
                button.text = getString(R.string.button_goodbye)
            } else {
                textView.text = ""
                button.text = getString(R.string.button_hello)
            }
        }
    }
}
