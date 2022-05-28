package come.example.searchandfavorite.domain.repository

import come.example.core.Resource
import come.example.searchandfavorite.domain.model.CityWeather
import come.example.searchandfavorite.domain.model.FavoriteCity
import kotlinx.coroutines.flow.Flow

interface SearchAndFavoriteRepository {
    fun getCityWeather(name: String): Flow<Resource<CityWeather?>>
    suspend fun getFavoriteCities(): List<FavoriteCity>
    suspend fun cacheFavoriteCity(favoriteCity: FavoriteCity)
    suspend fun isCityFavorite(name: String): Boolean
}