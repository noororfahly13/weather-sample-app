package come.example.weathersample.home.presentation

import come.example.weathersample.home.domain.model.Weather


sealed class HomeScreenState {
    object Idle : HomeScreenState()
    object NoCurrentLocation : HomeScreenState()
    object Loading : HomeScreenState()
    data class Error(val error: String) : HomeScreenState()
    data class Data(val movies: List<Weather>) : HomeScreenState()
}