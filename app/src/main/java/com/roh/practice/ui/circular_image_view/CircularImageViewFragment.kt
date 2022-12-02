package com.roh.practice.ui.circular_image_view

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.roh.practice.R
import com.roh.practice.databinding.FragmentCircularImageViewBinding


class CircularImageViewFragment : Fragment() {
    private var _binding: FragmentCircularImageViewBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.icBack.setOnClickListener {
            findNavController().navigateUp()
        }

        val icon = BitmapFactory.decodeResource(
            requireContext().resources,
            R.mipmap.test_img_2
        )

        for (i in 1..10) {
            Log.d("CIRCULAR_IMAGE", "i: $i" )
            //binding.imgPic.setImageBitmap(icon)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCircularImageViewBinding.inflate(inflater, container, false)
        return binding.root
    }


}