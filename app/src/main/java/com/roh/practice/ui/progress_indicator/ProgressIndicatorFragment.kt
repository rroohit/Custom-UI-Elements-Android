package com.roh.practice.ui.progress_indicator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.roh.practice.R
import com.roh.practice.databinding.FragmentProgressIndicatorBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProgressIndicatorFragment : Fragment() {
    private var _binding: FragmentProgressIndicatorBinding? = null
    private val binding get() = _binding!!

    private val progressViewModel: ProgressIndicatorViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {

            launch {

                binding.indicator.noOfIndicators = 5
                binding.indicator.selectedIndicator = 2
                binding.indicator.isIndeterminate = false
            }

        }





        binding.icBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgressIndicatorBinding.inflate(inflater, container, false)
        return binding.root
    }

}