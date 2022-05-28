package com.example.weather_sample.home.domain.model

data class DailyWeather(
    val dt: Long?,
    val temp: Temp?,
    val humidity: Double?,
    val windSpeed: Double?,
    val weather: List<WeatherDetails>?,
)

data class Temp(
    val min: Double?,
    val max: Double?,
)