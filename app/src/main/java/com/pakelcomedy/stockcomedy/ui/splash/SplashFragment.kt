package com.pakelcomedy.stockcomedy.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pakelcomedy.stockcomedy.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashViewModel = ViewModelProvider(this)[SplashViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get references to the views
        val tvAppTitle: TextView = view.findViewById(R.id.tvAppTitle)
        val tvSubtitle: TextView = view.findViewById(R.id.tvSubtitle)

        // Apply fade-in animation to the title
        val fadeInTitle = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        tvAppTitle.startAnimation(fadeInTitle)

        // Apply slide-in animation to the subtitle
        val slideInSubtitle = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in_bottom)
        tvSubtitle.startAnimation(slideInSubtitle)

        // Observe ViewModel data (optional)
        splashViewModel.appVersion.observe(viewLifecycleOwner) { version ->
            println("App Version: $version")
        }

        // Navigate to the next screen after a delay
        Handler(Looper.getMainLooper()).postDelayed({
            // Add scale animation before navigating
            val scaleAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.scale_up)
            tvAppTitle.startAnimation(scaleAnimation)
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }, 3000) // 3 seconds delay
    }
}