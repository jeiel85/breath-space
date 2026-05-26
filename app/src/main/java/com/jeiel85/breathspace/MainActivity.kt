package com.jeiel85.breathspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.jeiel85.breathspace.ui.navigation.BreathNavGraph
import com.jeiel85.breathspace.ui.navigation.NavRoutes
import com.jeiel85.breathspace.ui.theme.DeepMidnight
import com.jeiel85.breathspace.ui.theme.MyApplicationTheme
import com.jeiel85.breathspace.ui.theme.SoftPurple
import com.jeiel85.breathspace.ui.viewmodel.BreathViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        // Handle deep link trigger from notification click
        val deepLinkMood = intent?.getBooleanExtra("DEEP_LINK_TO_MOOD_CHECK", false) ?: false

        setContent {
            MyApplicationTheme {
                val viewModel: BreathViewModel = viewModel()
                val navController = rememberNavController()
                val prefs by viewModel.userPreferences.collectAsState()

                // Wait for DB preferences row to load
                if (prefs.id == 1) {
                    val startDest = if (prefs.isOnboardingCompleted) {
                        if (deepLinkMood) NavRoutes.MOOD_CHECK else NavRoutes.HOME
                    } else {
                        NavRoutes.ONBOARDING
                    }

                    BreathNavGraph(
                        navController = navController,
                        viewModel = viewModel,
                        startDestination = startDest
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(DeepMidnight),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = SoftPurple)
                    }
                }
            }
        }
    }
}
