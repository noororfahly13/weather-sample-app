package com.example.search_and_favorite.presentation.city

import com.example.search_and_favorite.domain.model.CityWeather

sealed class CityScreenState {
    object Idle : CityScreenState()
    object NoCityLocation : CityScreenState()
    object Loading : CityScreenState()
    data class Error(val error: String) : CityScreenState()
    data class Data(val weather: CityWeather) : CityScreenState()
}