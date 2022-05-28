package com.example.search_and_favorite.domain.usecases

import com.example.core.Resource
import com.example.search_and_favorite.domain.model.CityWeather
import com.example.search_and_favorite.domain.repository.SearchAndFavoriteRepository
import kotlinx.coroutines.flow.Flow

class GetCityWeatherUseCase(private val repository: SearchAndFavoriteRepository) {
    operator fun invoke(name: String): Flow<Resource<CityWeather?>> {
        return repository.getCityWeather(name)
    }
}