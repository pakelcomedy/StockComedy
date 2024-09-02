package com.pakelcomedy.stockcomedy

import com.pakelcomedy.stockcomedy.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.pakelcomedy.stockcomedy.fragment.PortfolioFragment
import com.pakelcomedy.stockcomedy.fragment.StockListFragment
import com.pakelcomedy.stockcomedy.fragment.WorkTapFragment
import com.pakelcomedy.stockcomedy.viewmodel.PortfolioViewModel
import com.pakelcomedy.stockcomedy.viewmodel.StockListViewModel
import com.pakelcomedy.stockcomedy.viewmodel.WorkTapViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // ViewModels
    private val portfolioViewModel: PortfolioViewModel by viewModels()
    private val stockListViewModel: StockListViewModel by viewModels()
    private val workTapViewModel: WorkTapViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            // Set default fragment
            loadFragment(PortfolioFragment())
        }

        setupNavigation()
    }

    private fun setupNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_portfolio -> loadFragment(PortfolioFragment())
                R.id.action_stock_list -> loadFragment(StockListFragment())
                R.id.action_work_tap -> loadFragment(WorkTapFragment())
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
        return true
    }
}
