package com.example.weather_sample.home.data.api

import com.example.core.network.constants.ConnectionEndPoint
import com.example.core.network.response.ApiResponse
import com.example.weather_sample.home.data.entity.CityEntity
import com.example.weather_sample.home.data.entity.WeatherEntity
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * REST API access points
 */
interface HomeService {

    @GET(ConnectionEndPoint.ONE_CALL)
    suspend fun fetchWeatherForLocation(@Query("lat") lat: Double?, @Query("lon") lng: Double?): ApiResponse<WeatherEntity>

    @GET(ConnectionEndPoint.GEO_REVERSE)
    suspend fun fetchCityName(@Query("lat") lat: Double?, @Query("lon") lng: Double?): ApiResponse<List<CityEntity>>
}