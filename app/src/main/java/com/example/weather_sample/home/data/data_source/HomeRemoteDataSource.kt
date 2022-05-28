package com.example.weather_sample.home.data.data_source

import com.example.core.network.response.ApiResponse
import com.example.weather_sample.home.data.api.HomeService
import com.example.weather_sample.home.data.entity.CityEntity
import com.example.weather_sample.home.data.entity.WeatherEntity


interface HomeRemoteDataSource {
    suspend fun getCurrentLocationWeather(lat: Double, lng: Double): ApiResponse<WeatherEntity>
    suspend fun getCityName(lat: Double, lng: Double): ApiResponse<List<CityEntity>>
}

class HomeRemoteDataSourceImpl(
    private val homeService: HomeService
) : HomeRemoteDataSource {
    override suspend fun getCurrentLocationWeather(lat: Double, lng: Double): ApiResponse<WeatherEntity> {
        return homeService.fetchWeatherForLocation(lat, lng)
    }

    override suspend fun getCityName(lat: Double, lng: Double): ApiResponse<List<CityEntity>> {
        return homeService.fetchCityName(lat, lng)
    }

}