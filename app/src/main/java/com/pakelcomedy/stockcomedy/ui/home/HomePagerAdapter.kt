package com.pakelcomedy.stockcomedy.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pakelcomedy.stockcomedy.ui.home.crypto.CryptoFragment
import com.pakelcomedy.stockcomedy.ui.home.stock.StockFragment

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2 // Number of tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> StockFragment() // Fragment untuk tab Stock
            1 -> CryptoFragment() // Fragment untuk tab Crypto
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}