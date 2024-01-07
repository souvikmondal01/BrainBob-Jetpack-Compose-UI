package com.kivous.jetpackcomposeui

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kivous.jetpackcomposeui.screens.HomeScreen
import com.kivous.jetpackcomposeui.screens.StartScreen
import com.kivous.jetpackcomposeui.ui.theme.JetpackComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeUITheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "start", enterTransition = {
            fadeIn(animationSpec = tween(100))
        }, exitTransition = {
            fadeOut(animationSpec = tween(100))
        }) {
        composable("start") {
            StartScreen {
                navController.navigate("home")
            }
        }
        composable("home") {
            HomeScreen()
        }
    }
}

