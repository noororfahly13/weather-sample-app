package com.example.search_and_favorite.presentation.favorite

import com.example.search_and_favorite.domain.model.FavoriteCity


sealed class FavoriteScreenState {
    object Idle : FavoriteScreenState()
    object Loading : FavoriteScreenState()
    data class Error(val error: String) : FavoriteScreenState()
    data class Data(val favorites: List<FavoriteCity>) : FavoriteScreenState()
}