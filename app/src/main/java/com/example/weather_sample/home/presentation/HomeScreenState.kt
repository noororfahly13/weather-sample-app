package com.example.weather_sample.home.presentation

import com.example.weather_sample.home.domain.model.Weather


sealed class HomeScreenState {
    object Idle : HomeScreenState()
    object NoCurrentLocation : HomeScreenState()
    object Loading : HomeScreenState()
    data class Error(val error: String) : HomeScreenState()
    data class Data(val weather: Weather) : HomeScreenState()
}