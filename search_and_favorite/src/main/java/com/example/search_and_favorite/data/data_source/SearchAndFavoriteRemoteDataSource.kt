package com.example.search_and_favorite.data.data_source

import com.example.core.network.response.ApiResponse
import com.example.search_and_favorite.data.api.SearchAndFavoriteService
import com.example.search_and_favorite.data.entity.CityWeatherEntity


interface SearchAndFavoriteRemoteDataSource {
    suspend fun getCityWeather(name: String): ApiResponse<CityWeatherEntity>
}

class SearchAndFavoriteRemoteDataSourceImpl(
    private val service: SearchAndFavoriteService
) : SearchAndFavoriteRemoteDataSource {

    override suspend fun getCityWeather(name: String): ApiResponse<CityWeatherEntity> {
        return service.fetchWeatherForCity(name)
    }

}