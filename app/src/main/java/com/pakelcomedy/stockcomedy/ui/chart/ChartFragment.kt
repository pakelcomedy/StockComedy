package com.pakelcomedy.stockcomedy.ui.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pakelcomedy.stockcomedy.databinding.FragmentChartBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.widget.ViewPager2

class ChartFragment : Fragment() {

    private var _binding: FragmentChartBinding? = null
    private val binding get() = _binding!!

    private lateinit var chartPagerAdapter: ChartPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve the argument to check if it's from CryptoFragment
        val isFromCrypto = arguments?.getBoolean("isFromCrypto") ?: false
        if (isFromCrypto) {
            binding.tabLayout.visibility = View.GONE
        }

        // Setup ViewPager2 with adapter
        chartPagerAdapter = ChartPagerAdapter(requireActivity())
        binding.viewPager.adapter = chartPagerAdapter

        // Setup TabLayout to sync with ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Key Stats"
                1 -> tab.text = "Order Book"
                2 -> tab.text = "Profile"
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}