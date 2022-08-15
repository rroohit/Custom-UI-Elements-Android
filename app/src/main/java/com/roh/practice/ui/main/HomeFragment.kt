package com.roh.practice.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.roh.practice.R
import com.roh.practice.domain.util.HomeDestinations
import com.roh.practice.data.local.HomeListItemData.Companion.homeListData
import com.roh.practice.databinding.FragmentHomeBinding
import com.roh.practice.domain.model.HomeItem
import com.roh.practice.ui.main.util.HomeItemAdapter
import com.roh.practice.ui.main.util.OnItemClickListener


class HomeFragment : Fragment(), OnItemClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = HomeItemAdapter(this)
        binding.homeRv.adapter = adapter
        adapter.submitList(homeListData)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(homeItem: HomeItem) {
        when(homeItem.HomeDestination){
            HomeDestinations.CIRCULARIMAGEVIEW -> {
                findNavController().navigate(R.id.action_homeFragment_to_circularImageViewFragment)
            }
            HomeDestinations.SEEKBAR -> {
                findNavController().navigate(R.id.action_homeFragment_to_seekbarFragment)

            }
            HomeDestinations.SNACKBAR -> {

            }
            null -> TODO()
        }

    }


}