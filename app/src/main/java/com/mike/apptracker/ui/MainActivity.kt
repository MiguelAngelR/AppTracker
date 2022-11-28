package com.mike.apptracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.OnBackPressedCallback
import androidx.core.net.toUri
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.mike.apptracker.R
import com.mike.apptracker.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        subscribeUI()
    }


    private fun subscribeUI() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val navController: NavController = findNavController(R.id.nav_host_container)
                val currentDestination = navController.currentDestination
                if (currentDestination?.id == R.id.mainFragment
                ) {
                    finish() // Back is pressed... Finishing the activity
                } else {
                    navController.navigateUp()
                }
            }
        })

        // Set up an OnPreDrawListener to the root view.
        val content = findViewById<View>(android.R.id.content)
        content.viewTreeObserver.run {
            addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
                // Check if the initial data is ready.
                override fun onPreDraw(): Boolean {
                    // Check if the initial data is ready.
                    content.viewTreeObserver.removeOnPreDrawListener(this)
                    findNavController(R.id.nav_host_container).run {navigate(R.id.mainFragment) }
                    return true
                }
            })
        }
    }



}