package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.Display
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.EditText

const val EXTRA_MESSAGE = "Sunat.Pra 6088130.MASSAGE"
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button: Button = findViewById(R.id.hello)
        button.setOnClickListener{v: View? ->
            val editText = findViewById<EditText>(R.id.text)
            val message = editText.text.toString()
            val intent = Intent(this,DisplayMessageActivity::class.java).apply { putExtra(EXTRA_MESSAGE, message) }
            startActivity(intent)
            Toast.makeText(this,"Hello I'm Sunat",Toast.LENGTH_LONG).show()
        }

    }
}
