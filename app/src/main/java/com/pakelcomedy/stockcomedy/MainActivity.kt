package com.pakelcomedy.stockcomedy

import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.pakelcomedy.stockcomedy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var doubleBackToExitPressedOnce = false // To handle double back press to exit

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
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
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
        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment).findNavController()
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    // Override the back button press
    override fun onBackPressed() {
        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment).findNavController()

        // If we're at the home screen, show the Toast and handle double back press to exit
        if (navController.currentDestination?.id == R.id.navigation_home) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed() // Exit the app
                return
            }

            this.doubleBackToExitPressedOnce = true
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()

            // Reset double press flag after 2 seconds
            android.os.Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)

        } else {
            // Navigate back to home on back press
            navController.navigate(R.id.navigation_home)

            // Update the BottomNavigationView to show the "home" item
            binding.bottomNavigation.selectedItemId = R.id.navigation_home
        }
    }
}