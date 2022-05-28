package come.example.searchandfavorite.presentation.city

import come.example.searchandfavorite.domain.model.CityWeather

sealed class CityScreenState {
    object Idle : CityScreenState()
    object NoCityLocation : CityScreenState()
    object Loading : CityScreenState()
    data class Error(val error: String) : CityScreenState()
    data class Data(val weather: CityWeather) : CityScreenState()
}