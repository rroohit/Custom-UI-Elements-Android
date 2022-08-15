package com.roh.practice.ui.snackbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.roh.practice.databinding.FragmentSnakbarBinding


class SnakbarFragment : Fragment() {
    private var _binding: FragmentSnakbarBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSnakbarBinding.inflate(inflater, container, false)
        return binding.root
    }


}