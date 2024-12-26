package com.pakelcomedy.stockcomedy.ui.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.pakelcomedy.stockcomedy.databinding.FragmentChartBinding

class ChartFragment : Fragment() {

    private var _binding: FragmentChartBinding? = null
    private val binding get() = _binding!!

    private lateinit var chartPagerAdapter: ChartPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup tombol back
        binding.back.setOnClickListener {
            findNavController().navigateUp() // Gunakan Navigation Component untuk kembali
        }

        // Get the 'isFromCrypto' argument passed from the previous fragment
        val isFromCrypto = arguments?.getBoolean("isFromCrypto", false) ?: false

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

        // Conditionally hide tabs based on isFromCrypto flag
        if (isFromCrypto) {
            binding.tabLayout.post {
                if (binding.tabLayout.tabCount > 0) {
                    // Remove tabs starting from the highest index to avoid shifting
                    binding.tabLayout.removeTabAt(binding.tabLayout.tabCount - 1) // Remove Profile tab
                    binding.tabLayout.removeTabAt(0) // Remove Key Stats tab
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}