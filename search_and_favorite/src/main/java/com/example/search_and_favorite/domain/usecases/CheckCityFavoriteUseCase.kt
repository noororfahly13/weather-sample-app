package com.example.search_and_favorite.domain.usecases

import com.example.search_and_favorite.domain.repository.SearchAndFavoriteRepository

class CheckCityFavoriteUseCase(private val repository: SearchAndFavoriteRepository) {
    suspend operator fun invoke(name: String): Boolean {
        return repository.isCityFavorite(name)
    }
}