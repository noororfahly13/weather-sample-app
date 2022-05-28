package com.example.weather_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.weather_sample.navigation.NavGraph
import com.example.weather_sample.ui.theme.WeatherSampleTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherSampleTheme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}