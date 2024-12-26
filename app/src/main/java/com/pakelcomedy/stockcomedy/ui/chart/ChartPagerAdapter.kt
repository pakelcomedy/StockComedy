package com.pakelcomedy.stockcomedy.ui.chart

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pakelcomedy.stockcomedy.ui.chart.keystat.KeyStatFragment
import com.pakelcomedy.stockcomedy.ui.chart.orderbook.OrderBookFragment
import com.pakelcomedy.stockcomedy.ui.chart.profilestock.ProfileStockFragment

class ChartPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        // Jumlah tab yang akan ditampilkan dalam ViewPager2
        return 3 // Contoh: Key Stats, Order Book, Profile
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> KeyStatFragment()  // Key Stats
            1 -> OrderBookFragment()  // Order Book
            2 -> ProfileStockFragment()  // Profile
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}