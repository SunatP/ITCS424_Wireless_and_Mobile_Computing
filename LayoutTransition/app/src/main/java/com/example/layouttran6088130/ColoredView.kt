package com.example.layouttran6088130

import android.content.Context
import android.view.View
import android.view.ViewGroup
import java.lang.Math.random

internal class ColoredView(context: Context) : View(context) {
    private var mExpanded = false
    private val mCompressedParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100)
    private val mExpandedParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,400)

    init {
        val red = (random() * 128 + 127).toInt()
        val green = (random() * 128 + 127).toInt()
        val blue = (random() * 128 + 127).toInt()
        val color = 0xff shl 24 or (red shl 16) or (green shl 8) or blue
        setBackgroundColor(color)
        layoutParams = mCompressedParams
        setOnClickListener {
            layoutParams = if (mExpanded) mCompressedParams else mExpandedParams
            mExpanded = !mExpanded
            requestLayout()
        }
    }
}