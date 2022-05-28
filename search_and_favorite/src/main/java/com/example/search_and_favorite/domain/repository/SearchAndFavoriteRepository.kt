package com.example.search_and_favorite.domain.repository

import com.example.core.Resource
import com.example.search_and_favorite.domain.model.CityWeather
import com.example.search_and_favorite.domain.model.FavoriteCity
import kotlinx.coroutines.flow.Flow

interface SearchAndFavoriteRepository {
    fun getCityWeather(name: String): Flow<Resource<CityWeather?>>
    suspend fun getFavoriteCities(): List<FavoriteCity>
    suspend fun cacheFavoriteCity(favoriteCity: FavoriteCity)
    suspend fun isCityFavorite(name: String): Boolean
    suspend fun removeFavoriteCity(favoriteCity: FavoriteCity)
}