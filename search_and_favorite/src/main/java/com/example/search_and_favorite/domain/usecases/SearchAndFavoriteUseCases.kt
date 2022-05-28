package com.example.search_and_favorite.domain.usecases

data class SearchAndFavoriteUseCases(
    val getCityWeatherUseCase: GetCityWeatherUseCase,
    val cacheFavoriteCityUseCase: CacheFavoriteCityUseCase,
    val getFavoriteCitiesUseCase: GetFavoriteCitiesUseCase,
    val checkCityFavoriteUseCase: CheckCityFavoriteUseCase
)
