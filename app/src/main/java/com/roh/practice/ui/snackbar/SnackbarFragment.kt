package com.roh.practice.ui.snackbar

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.SnackbarLayout
import com.roh.practice.R
import com.roh.practice.databinding.FragmentSnackbarBinding
import com.roh.practice.ui.snackbar.util.CustomSnackbar


class SnackbarFragment : Fragment() {
    private var _binding: FragmentSnackbarBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dpHeight = (resources.displayMetrics.heightPixels * 0.8).toInt()


        binding.btnShowSnackbar.setOnClickListener {

            val snackbar = Snackbar.make(binding.root, "", Snackbar.LENGTH_LONG)

            val snackbarView = snackbar.view
            val params = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )

            params.setMargins(20, dpHeight, 20, 0)
            snackbarView.layoutParams = params

            snackbarView.setBackgroundColor(Color.TRANSPARENT)


            val customSnackView: View = layoutInflater.inflate(R.layout.item_custom_snackbar, null)


            val snackbarLayout = snackbar.view as SnackbarLayout

            snackbarLayout.addView(customSnackView)


            snackbar.show()


            CustomSnackbar.makeSnackbar(binding.rootContainer, "Customise me", Snackbar.LENGTH_LONG)?.show()

        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSnackbarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}