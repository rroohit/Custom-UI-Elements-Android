package com.roh.practice.ui.circular_image_view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.roh.practice.R
import com.roh.practice.databinding.FragmentCircularImageViewBinding


class CircularImageViewFragment : Fragment() {
    private var _binding: FragmentCircularImageViewBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCircularImageViewBinding.inflate(inflater, container, false)
        return binding.root
    }


}