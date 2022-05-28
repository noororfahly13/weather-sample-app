package com.example.search_and_favorite.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.search_and_favorite.domain.model.FavoriteCity
import com.example.search_and_favorite.domain.usecases.SearchAndFavoriteUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val useCases: SearchAndFavoriteUseCases
) : ViewModel() {

    private val _favoritesState: MutableStateFlow<FavoriteScreenState> = MutableStateFlow(FavoriteScreenState.Idle)
    val favoritesState: StateFlow<FavoriteScreenState> = _favoritesState

    init {
        getFavorites()
    }

    private fun getFavorites() {
        viewModelScope.launch {
            _favoritesState.value = FavoriteScreenState.Data(useCases.getFavoriteCitiesUseCase.invoke())
        }

    }


    fun removeFavoriteCity(favoriteCity: FavoriteCity) {
        viewModelScope.launch {
            useCases.removeFavoriteCityUseCase(favoriteCity)
            _favoritesState.value = FavoriteScreenState.Data(useCases.getFavoriteCitiesUseCase.invoke())
        }
    }
}