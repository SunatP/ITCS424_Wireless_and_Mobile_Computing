package com.example.simplecalculator6088130

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private var input1:EditText? = null
    private var input2:EditText? = null
    private var solution:EditText? = null
    private var operator:TextView? = null
    private var mContext:Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input1 = findViewById<View>(R.id.number) as EditText
        input2 = findViewById<View>(R.id.number2) as EditText
        solution = findViewById<View>(R.id.number3) as EditText
        operator = findViewById(R.id.textView) as TextView
        val plus = findViewById<View>(R.id.plus) as Button
        val minus = findViewById<View>(R.id.minus) as Button
        val multiply = findViewById<View>(R.id.multiply) as Button
        val pow = findViewById<View>(R.id.Pow) as Button
        val equal = findViewById<View>(R.id.equal) as Button
        plus.setOnClickListener{operator!!.text = "+"}
        minus.setOnClickListener{operator!!.text = "-"}
        multiply.setOnClickListener{operator!!.text = "*"}
        divide.setOnClickListener{operator!!.text = "/"}
        pow.setOnClickListener { operator!!.text = "POW" }
        equal.setOnClickListener {
            if(input1!!.text.length == 0 || input1!!.text.toString() === "" || input2!!.text.length == 0 || input2!!.text.toString() === "" )
            {
                mContext?.let { it1 -> AlertDialog.Builder(it1).setTitle("Error").setMessage("Some inputs are empty").setPositiveButton("OK", null).show() }
                return@setOnClickListener
            } else if (operator!!.text == "") {
                mContext?.let { it1 -> AlertDialog.Builder(it1).setTitle("Error").setMessage("Operator is null").setPositiveButton("OK", null).show() }
                return@setOnClickListener
            }

            val op1 = input1!!.text.toString().toDouble()
            val op2 = input2!!.text.toString().toDouble()
            var result = 0.0
            when (operator!!.text) {
                "+" -> {
                    result = op1 + op2
                }
                "-" -> {
                    result = op1 - op2
                }
                "*" -> {
                    result = op1 * op2
                }
                "/" -> {
                    result = op1 / op2
                }
                "POW" -> {
                    result = op1.pow(op2)
                }
            }
            solution!!.setText(result.toString())
        }

    }
}