package com.example.weather_sample.home.domain.repository

import com.example.core.Resource
import com.example.weather_sample.home.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getCurrentLocationWeather(lat: Double, lng: Double): Flow<Resource<Weather?>>
}