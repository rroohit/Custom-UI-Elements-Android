package com.roh.practice.domain.custom

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.drawable.toBitmap


class CircularImageView(
    context: Context,
    attributeSet: AttributeSet? = null,
) : AppCompatImageView(context, attributeSet) {

    private val paintCircle = Paint()
    private val circularPath = Path()
    var count = 0


    init {
        paintCircle.isAntiAlias = true

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

    override fun onDraw(canvas: Canvas) {
        count++
        Log.d("CIRCULAR_IMAGE", "onDraw: $count" )
        val d = drawable
        val w = width
        val c = width/2F

        d?.let { drawableImage ->

            val bitmap = getBitmap(drawableImage, w)


            circularPath.addCircle(c,c,c,Path.Direction.CCW)
            canvas.clipPath(circularPath)

            canvas.drawBitmap(bitmap, 0F, 0F, null)
//            super.onDraw(canvas)


        }


    }

    //get Bitmap from drawable
    private fun getBitmap(drawable: Drawable, size: Int): Bitmap {
        return drawable.toBitmap(size, size, null)
    }


}