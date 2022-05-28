package com.example.search_and_favorite.data.api

import com.example.core.network.constants.ConnectionEndPoint
import com.example.core.network.response.ApiResponse
import com.example.search_and_favorite.data.entity.CityWeatherEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAndFavoriteService {

    @GET(ConnectionEndPoint.WEATHER)
    suspend fun fetchWeatherForCity(@Query("q") name: String?): ApiResponse<CityWeatherEntity>

}