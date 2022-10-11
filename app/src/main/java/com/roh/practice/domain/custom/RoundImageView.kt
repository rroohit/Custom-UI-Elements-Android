package com.roh.practice.domain.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView


class RoundImageView(
    context: Context,
    attributeSet: AttributeSet? = null,
) : AppCompatImageView(context, attributeSet) {

    private val paint = Paint()
    private val cornerPath = Path()


    init {
        paint.style = Paint.Style.FILL
        paint.color = Color.TRANSPARENT
        paint.isAntiAlias = true


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

    override fun onDraw(canvas: Canvas) {
        val w = width.toFloat()
        val rectF = getSquareRect(w)

        cornerPath.addRoundRect(rectF, w/6,w/6, Path.Direction.CCW)

        canvas.drawRoundRect(rectF, w / 6, w / 6, paint)

        canvas.clipPath(cornerPath)

        super.onDraw(canvas)


    }

    private fun getSquareRect(size: Float) = RectF(0f, 0f, size, size)

}

