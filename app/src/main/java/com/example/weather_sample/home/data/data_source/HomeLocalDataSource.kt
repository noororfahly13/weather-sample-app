package com.example.weather_sample.home.data.data_source

import com.example.weather_sample.home.data.db.HomeDao
import com.example.weather_sample.home.data.entity.WeatherEntity


interface HomeLocalDataSource {
    suspend fun getCachedCurrentLocationWeather(lat: Double, lng: Double): WeatherEntity?
    suspend fun cacheCurrentLocationWeather(weatherEntity: WeatherEntity)
}

class HomeLocalDataSourceImpl(private val homeDao: HomeDao) : HomeLocalDataSource {
    override suspend fun getCachedCurrentLocationWeather(lat: Double, lng: Double): WeatherEntity? {
        return homeDao.getWeather()
    }

    override suspend fun cacheCurrentLocationWeather(weatherEntity: WeatherEntity) {
        return homeDao.insertWeather(weatherEntity)
    }

}