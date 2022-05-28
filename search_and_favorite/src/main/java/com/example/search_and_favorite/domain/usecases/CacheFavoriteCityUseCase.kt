package com.example.search_and_favorite.domain.usecases

import com.example.search_and_favorite.domain.model.FavoriteCity
import com.example.search_and_favorite.domain.repository.SearchAndFavoriteRepository

class CacheFavoriteCityUseCase(private val repository: SearchAndFavoriteRepository) {
    suspend operator fun invoke(favoriteCity: FavoriteCity) {
        return repository.cacheFavoriteCity(favoriteCity)
    }
}