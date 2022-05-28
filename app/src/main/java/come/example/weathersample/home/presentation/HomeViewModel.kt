package come.example.weathersample.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import come.example.core.Status
import come.example.weathersample.home.domain.usecases.HomeUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class HomeViewModel(
    private val homeUseCases: HomeUseCases,
) : ViewModel() {

    private val _homeState: MutableStateFlow<HomeScreenState> = MutableStateFlow(HomeScreenState.Idle)
    val homeState: StateFlow<HomeScreenState> = _homeState

    private var _latestLat: Double? = null
    private var _latestLng: Double? = null

    fun updateCurrentLocation(lat: Double?, lng: Double?) {
        if (lat == null || lng == null)
            _homeState.value = HomeScreenState.NoCurrentLocation
        else if (_latestLat == lat && _latestLng == lng) // don't sent network request if the location not updated
            return
        else {
            _latestLat = lat
            _latestLng = lng
            viewModelScope.launch {
                homeUseCases.getCurrentLocationWeather.invoke(lat, lng).collect { resource ->
                    _homeState.value = when (resource.status) {
                        Status.SUCCESS -> if (resource.dataIsNull()) HomeScreenState.Error("Empty Data") else HomeScreenState.Data(weather = resource.data!!)
                        Status.ERROR -> HomeScreenState.Error(resource.message ?: "Unknown error")
                        Status.LOADING -> HomeScreenState.Loading
                    }
                }
            }
        }
    }
}