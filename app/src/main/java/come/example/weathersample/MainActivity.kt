package come.example.weathersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import come.example.weathersample.navigation.NavGraph
import come.example.weathersample.ui.theme.WeatherSampleTheme

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