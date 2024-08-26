package com.example.android4lesson1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android4lesson1.R
import com.example.android4lesson1.databinding.FragmentViewPagerBinding
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
//class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {
//
//    private var _binding: FragmentViewPagerBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        initialize()
//    }
//
//    private fun initialize() {
//        binding.viewPager.adapter = ViewPagerAdapter(this)
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}