package com.pakelcomedy.stockcomedy.ui.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.pakelcomedy.stockcomedy.R

class PortfolioFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var llInfoPorto: LinearLayout
    private lateinit var stockCryptoEquitySection: LinearLayout
    private lateinit var llStockCryptoEquity: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_portfolio, container, false)

        // Initialize views
        viewPager = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout)
        llInfoPorto = view.findViewById(R.id.llInfoPorto)
        stockCryptoEquitySection = view.findViewById(R.id.llStockCryptoEquity)
        llStockCryptoEquity = view.findViewById(R.id.llStockCryptoEquity)

        // Set the adapter for ViewPager2
        val pagerAdapter = PortfolioPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        // Set up TabLayout with ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Stock"
                1 -> "Crypto"
                else -> "Tab $position"
            }
        }.attach()

        // Handle expand/collapse functionality for llInfoPorto
        llInfoPorto.setOnClickListener { toggleVisibility(stockCryptoEquitySection) }

        // Handle click on llStockCryptoEquity to close itself
        llStockCryptoEquity.setOnClickListener { stockCryptoEquitySection.visibility = View.GONE }

        return view
    }

    // Function to toggle visibility of a view
    private fun toggleVisibility(view: View) {
        view.visibility = if (view.visibility == View.GONE) View.VISIBLE else View.GONE
    }
}