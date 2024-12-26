package com.pakelcomedy.stockcomedy

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.pakelcomedy.stockcomedy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the status bar color and icons
        window.statusBarColor = ContextCompat.getColor(this, R.color.darkGray)

        // Set the Toolbar as the ActionBar
        setSupportActionBar(binding.toolbar)

        // Get the NavController from the NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        // Set up the BottomNavigationView with the NavController
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.navigation_home)
                    true
                }
                R.id.navigation_earn -> {
                    navController.navigate(R.id.navigation_earn)
                    true
                }
                R.id.navigation_portofolio -> {
                    navController.navigate(R.id.navigation_portofolio)
                    true
                }
                else -> false
            }
        }

        // Set up the ActionBar with NavController
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home, R.id.navigation_earn, R.id.navigation_portofolio)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Add destination changed listener to control visibility of the ActionBar and BottomNavigation
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    // Hide the action bar and bottom navigation when navigating to SplashFragment
                    supportActionBar?.hide()
                    binding.bottomNavigation.visibility = View.GONE
                    binding.toolbar.visibility = View.GONE
                }
                R.id.navigation_home -> {
                    // Show the action bar and bottom navigation
                    supportActionBar?.show()
                    binding.bottomNavigation.visibility = View.VISIBLE
                    binding.toolbar.visibility = View.GONE
                }
                R.id.navigation_earn -> {
                    // Show the action bar and bottom navigation
                    supportActionBar?.show()
                    binding.bottomNavigation.visibility = View.VISIBLE
                    binding.toolbar.visibility = View.GONE
                }
                R.id.navigation_portofolio -> {
                    // Show the action bar and bottom navigation
                    supportActionBar?.show()
                    binding.bottomNavigation.visibility = View.VISIBLE
                    binding.toolbar.visibility = View.GONE
                }
                R.id.chartFragment -> {
                    // Show the action bar and bottom navigation
                    supportActionBar?.show()
                    binding.bottomNavigation.visibility = View.GONE
                    binding.toolbar.visibility = View.GONE
                }
                else -> {
                    // Show the action bar and bottom navigation for other fragments
                    supportActionBar?.show()
                    binding.bottomNavigation.visibility = View.VISIBLE
                }
            }
        }

        // Set default selected item in the BottomNavigationView
        binding.bottomNavigation.selectedItemId = R.id.navigation_home
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment).findNavController()
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}