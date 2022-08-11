package com.roh.practice.ui.snackbar.util

import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.roh.practice.R

class CustomSnackbar(
    parent: ViewGroup,
    content: CustomSnackbarView
) : BaseTransientBottomBar<CustomSnackbar>(parent, content, content) {

    init {

    }

    companion object {
        fun makeSnackbar(viewGroup: ViewGroup, message: String, duration: Int): CustomSnackbar? {
            val parent = viewGroup.findSuitableParent() ?: throw IllegalArgumentException(
                " Please provide a valid view."
            )

            try {
                val customView = LayoutInflater.from(viewGroup.context).inflate(
                    R.layout.layout_custom_snackbar,
                    parent,
                    false
                ) as CustomSnackbarView

                customView.txtMsg.text = message

                return CustomSnackbar(parent, customView).setDuration(duration)

            } catch (e: Exception) {
                println("rohit e $e")
            }
            return  null
        }
    }

}