package com.example.weather_sample.home.domain.usecases

import com.example.core.Resource
import com.example.weather_sample.home.domain.model.Weather
import com.example.weather_sample.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentLocationWeather(private val repository: HomeRepository) {
    operator fun invoke(lat: Double, lng: Double): Flow<Resource<Weather?>> {
        return repository.getCurrentLocationWeather(lat, lng)
    }
}