package com.example.layouttran6088130

import android.animation.LayoutTransition
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addbtn = findViewById<Button>(R.id.addbutton)
        val rmbtn = findViewById<Button>(R.id.removebutton)
        val container = findViewById<LinearLayout>(R.id.container)
        val context: Context = this

        for (i in 0..1)
        {
            container.addView(ColoredView(this))
        }
        addbtn.setOnClickListener {
            container.addView(ColoredView(context),1)
        }
        rmbtn.setOnClickListener {
            container.removeViewAt(min(1,container.childCount - 1))
        }
        val transition = container.layoutTransition
        transition.enableTransitionType(LayoutTransition.CHANGING)
    }
}