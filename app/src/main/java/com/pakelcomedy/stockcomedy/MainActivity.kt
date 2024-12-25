package com.pakelcomedy.stockcomedy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.pakelcomedy.stockcomedy.R
import com.pakelcomedy.stockcomedy.ui.splash.SplashFragment  // Import your SplashFragment
import com.pakelcomedy.stockcomedy.ui.home.HomeFragment  // Import your HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up ActionBar
        setSupportActionBar(findViewById(R.id.toolbar))  // Ensure toolbar is in your layout (or use default)

        // Set up NavController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Set up the ActionBar to work with Navigation
        setupActionBarWithNavController(navController)

        // Hide the toolbar when displaying SplashFragment or HomeFragment
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment, R.id.homeFragment -> {
                    // Hide toolbar
                    supportActionBar?.hide()
                }
                else -> {
                    // Show toolbar for other fragments
                    supportActionBar?.show()
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navHostFragment.navController.navigateUp() || super.onSupportNavigateUp()
    }
}