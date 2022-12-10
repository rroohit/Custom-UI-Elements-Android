package com.roh.practice.domain.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.widget.ProgressBar
import com.roh.practice.R
import kotlin.math.roundToInt

class ProgressIndicator : ProgressBar {

    //To use default from xml input
    private var _noOfIndicators: Int = 2
    private var _indicatorColor: Int = Color.GRAY
    private var _indicatorColorFilled: Int = Color.BLACK
    private var _selectedIndicator: Int = 1

    /**
     * No of indicators on progress bar. >= 2
     */
    var noOfIndicators: Int
        get() = _noOfIndicators
        set(value) {
            _noOfIndicators = value
        }

    //Color of indicator which yet to fill
    var indicatorColor: Int
        get() = _indicatorColor
        set(value) {
            _indicatorColor = value
        }

    //Color of indicator after filled
    var indicatorColorFilled: Int
        get() = _indicatorColorFilled
        set(value) {
            _indicatorColorFilled = value
        }

    //Set progress length according to indicators..
    var selectedIndicator: Int
        get() = _selectedIndicator
        set(value) {
            Log.d("selectedIndicator", "selectedIndicator: => $selectedIndicator ")
            if (value <= 0) {
                _selectedIndicator = 1
                if (selectedIndicator <= noOfIndicators) {
                    progress = 10
                }
            } else {
                _selectedIndicator = value
                if (selectedIndicator <= noOfIndicators) {
                    progress = 10
                }
            }

        }


    private val paintCircle = Paint()

    var count = 0

    init {
        paintCircle.isAntiAlias = true
        paintCircle.color = _indicatorColor
        paintCircle.style = Paint.Style.FILL

    }

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        val attr = context.obtainStyledAttributes(
            attrs, R.styleable.ProgressIndicator, defStyle, 0
        )

        val indicatorCount = attr.getInt(
            R.styleable.ProgressIndicator_noOfIndicators, 2
        )
        _noOfIndicators = if (indicatorCount <= 1) 2 else indicatorCount

        val indicatorSelected = attr.getInt(
            R.styleable.ProgressIndicator_selectedIndicator, 1
        )

        _selectedIndicator = if (indicatorSelected <= 1) {
            1
        } else if (indicatorSelected >= noOfIndicators) {
            noOfIndicators
        } else {
            indicatorSelected
        }

        attr.recycle()

    }


    override fun onDraw(canvas: Canvas) {
        count++
        Log.d("PROGRESS_INDICATOR", "onDraw: count => $count :: $progress")
        super.onDraw(canvas)

        val yCenter = height / 2F
        val circleRadius = scaleY * 12
        val w = width - (circleRadius * 2)

        val positionDiff = ((w) / (noOfIndicators - 1))

        for (indicatorIndex in 1..noOfIndicators) {

            //To fill selected indicator color
            paintCircle.color =
                if (indicatorIndex <= selectedIndicator) indicatorColorFilled else indicatorColor

            //Setting up each indicator position
            val position = (positionDiff * (indicatorIndex - 1))

            //Drawing indicators
            canvas.drawCircle(position + circleRadius, yCenter, circleRadius, paintCircle)

        }

        progress = 10

    }


    //For handling Y direction scale of view
    override fun setScaleY(scaleY: Float) {
        Log.d("PROGRESS_INDICATOR", "setScaleY: => $scaleY")

        if (scaleY < 5) {
            setPadding(0, (5 * 2), 0, (5 * 2))
            val y = 5 / 3F
            super.setScaleY(y)
        } else {
            setPadding(0, (scaleY * 2).toInt(), 0, (scaleY * 2).toInt())
            val y = scaleY / 3
            super.setScaleY(y)
        }
    }


    //Stop indeterminate progress behaviour
    override fun setIndeterminate(indeterminate: Boolean) {
        super.setIndeterminate(false)
    }

    //Handle default progress
    override fun setProgress(progress: Int) {
        if (width > 0) {
            val circleRadius = scaleY * 12
            val w = width - (circleRadius * 2)
            val positionDiff = ((w) / (noOfIndicators - 1))

            val length = (positionDiff * (selectedIndicator - 1)) / width
            val progressLength = ((length) * (100)).roundToInt()

            Log.d("PROGRESS_INDICATOR", "progressLength => $progressLength")

            super.setProgress(progressLength + 1)

        } else {
            super.setProgress(0)
        }

    }

}