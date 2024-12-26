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

        // Ensure compatibility with different Android versions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            binding.root.viewTreeObserver.addOnPreDrawListener {
                val insetsController = window.insetsController
                insetsController?.setSystemBarsAppearance(
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                )
                true
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        // Set the Toolbar as the ActionBar
        setSupportActionBar(binding.toolbar)

        // Find the NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        // Define AppBarConfiguration for fragments with no up button
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_earn,
                R.id.navigation_portofolio
            )
        )

        // Set up the ActionBar with NavController
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Add destination changed listener to control visibility of the ActionBar
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment, R.id.homeFragment -> {
                    // Hide the action bar when navigating to SplashFragment or HomeFragment
                    supportActionBar?.hide()
                }
                else -> {
                    // Show the action bar for other fragments
                    supportActionBar?.show()
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment).findNavController()
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}