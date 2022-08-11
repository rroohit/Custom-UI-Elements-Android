package com.roh.practice.ui.snackbar.util

import android.animation.AnimatorSet
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.OvershootInterpolator
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.ContentViewCallback
import com.roh.practice.R

class CustomSnackbarView
constructor(
    context: Context,
    attr: AttributeSet? = null,
    defaultStyle: Int = 0
): ConstraintLayout(context, attr, defaultStyle), ContentViewCallback {

    var txtMsg : TextView

    init {
        View.inflate(context, R.layout.item_custom_snackbar, this)

        this.txtMsg = findViewById(R.id.txt_snackbar_msg)
    }

    override fun animateContentIn(delay: Int, duration: Int) {
        val animatorSet = AnimatorSet().apply {
            interpolator = OvershootInterpolator()
            setDuration(500)
        }
        animatorSet.start()
    }

    override fun animateContentOut(delay: Int, duration: Int) {

    }
}