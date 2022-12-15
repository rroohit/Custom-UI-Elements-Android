package com.roh.practice.domain.custom

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout

class EditTextOutLine : TextInputLayout {


    init {



    }



    override fun setBoxStrokeWidth(boxStrokeWidth: Int) {
        super.setBoxStrokeWidth(boxStrokeWidth)
    }

    override fun setLabelFor(id: Int) {
        super.setLabelFor(id)
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
    }

}