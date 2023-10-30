package com.example.my.lovecalculate.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.my.lovecalculate.R
import com.example.my.lovecalculate.databinding.FragmentOnBoarding2Binding
import com.example.my.lovecalculate.pref.Pref
import com.example.my.lovecalculate.ui.onboarding.adapter.OnBoardingAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoarding2Binding
    private val adapter = OnBoardingAdapter(this::onClick)

    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoarding2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
    }

    private fun onClick() {
        pref.isUserSeen()
        findNavController().navigate(R.id.calculateFragment)
    }

}