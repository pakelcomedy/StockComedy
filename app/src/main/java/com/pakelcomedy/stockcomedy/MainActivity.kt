package com.pakelcomedy.stockcomedy

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private val stockMarketFragment = StockDetailFragment()
    private val workTapFragment = WorkTapFragment()
    private val portfolioFragment = PortfolioFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager

        // Set default fragment
        if (savedInstanceState == null) {
            showFragment(stockMarketFragment)
        }

        // Set up navigation buttons
        val btnStockMarket: Button = findViewById(R.id.btnStockMarket)
        val btnWorkTap: Button = findViewById(R.id.btnWorkTap)
        val btnPortfolio: Button = findViewById(R.id.btnPortfolio)

        btnStockMarket.setOnClickListener {
            showFragment(stockMarketFragment)
        }

        btnWorkTap.setOnClickListener {
            showFragment(workTapFragment)
        }

        btnPortfolio.setOnClickListener {
            showFragment(portfolioFragment)
        }
    }

    private fun showFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .addToBackStack(null) // Tambahkan ke back stack untuk navigasi yang lebih baik
            .commit()
    }
}
