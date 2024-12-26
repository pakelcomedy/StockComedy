package com.pakelcomedy.stockcomedy.ui.portfolio

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pakelcomedy.stockcomedy.ui.portfolio.crypto.CryptoPortfolioFragment
import com.pakelcomedy.stockcomedy.ui.portfolio.stock.StockPortfolioFragment

class PortfolioPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    // Return the fragment for each tab
    override fun getItemCount(): Int {
        return 2 // Only Stock and Crypto tabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> StockPortfolioFragment()  // Stock tab
            1 -> CryptoPortfolioFragment() // Crypto tab
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}