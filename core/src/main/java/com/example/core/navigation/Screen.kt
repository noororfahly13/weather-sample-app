package com.example.core.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object City : Screen("city_screen/{name}") {
        fun passName(name: String) = "city_screen/$name"
    }

    object Favorite : Screen("favorite_screen")
}
