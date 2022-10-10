package com.roh.practice.ui.workmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.roh.practice.databinding.FragmentWorkManagerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkManagerFragment : Fragment() {
    private var _binding: FragmentWorkManagerBinding? = null
    private val binding get() = _binding!!

    private val workViewModel : WorkViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {

            workViewModel.token.collect { token ->
                binding.txtToken.text = token
            }


        }


        popBack()
    }

    private fun popBack(){
        binding.icBack.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkManagerBinding.inflate(inflater, container, false)
        return binding.root

    }


}