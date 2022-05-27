package come.example.weathersample.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
}
