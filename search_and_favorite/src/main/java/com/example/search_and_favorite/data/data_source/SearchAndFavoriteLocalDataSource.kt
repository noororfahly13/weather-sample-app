package com.example.search_and_favorite.data.data_source

import com.example.search_and_favorite.data.db.SearchAndFavoriteDao
import com.example.search_and_favorite.data.entity.FavoriteCityEntity


interface SearchAndFavoriteLocalDataSource {
    suspend fun getFavoriteCities(): List<FavoriteCityEntity>?
    suspend fun cacheFavoriteCity(favoriteCityEntity: FavoriteCityEntity)
    suspend fun isCityFavorite(name: String): Boolean
    suspend fun removeFavoriteCity(favoriteCityEntity: FavoriteCityEntity)

}

class SearchAndFavoriteLocalDataSourceImpl(private val dao: SearchAndFavoriteDao) : SearchAndFavoriteLocalDataSource {
    override suspend fun getFavoriteCities(): List<FavoriteCityEntity>? {
        return dao.getFavoriteCities()
    }

    override suspend fun cacheFavoriteCity(favoriteCityEntity: FavoriteCityEntity) {
        return dao.insertFavoriteCity(favoriteCityEntity)
    }

    override suspend fun isCityFavorite(name: String): Boolean {
        return dao.getFavoriteCity(name) != null
    }

    override suspend fun removeFavoriteCity(favoriteCityEntity: FavoriteCityEntity) {
        return dao.removeFavoriteCity(favoriteCityEntity.name)
    }

}