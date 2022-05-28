package come.example.searchandfavorite.presentation.city

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import come.example.core.Status
import come.example.searchandfavorite.domain.model.FavoriteCity
import come.example.searchandfavorite.domain.usecases.SearchAndFavoriteUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CityViewModel(
    private val useCases: SearchAndFavoriteUseCases
) : ViewModel() {

    private val _cityState: MutableStateFlow<CityScreenState> = MutableStateFlow(CityScreenState.Idle)
    val cityState: StateFlow<CityScreenState> = _cityState

    private val _cityFavoriteState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val cityFavoriteState: StateFlow<Boolean> = _cityFavoriteState


    fun updateCity(name: String?) {
        if (name == null || name == "")
            _cityState.value = CityScreenState.NoCityLocation
        else {
            viewModelScope.launch {
                useCases.getCityWeatherUseCase.invoke(name).collect { resource ->
                    _cityState.value = when (resource.status) {
                        Status.SUCCESS -> if (resource.dataIsNull()) CityScreenState.NoCityLocation else CityScreenState.Data(weather = resource.data!!)
                        Status.ERROR -> CityScreenState.Error(resource.message ?: "Unknown error")
                        Status.LOADING -> CityScreenState.Loading
                    }
                }
            }
        }
    }

    fun isCityFavorite(name: String?) {
        if (name == null || name == "")
            _cityFavoriteState.value = false
        else {
            viewModelScope.launch {
                _cityFavoriteState.value = useCases.checkCityFavoriteUseCase.invoke(name)
            }
        }
    }

    fun cacheFavoriteCity(name: String?) {
        if (name == null || name == "")
            _cityFavoriteState.value = false
        else {
            viewModelScope.launch {
                useCases.cacheFavoriteCityUseCase(FavoriteCity(name))
                _cityFavoriteState.value = true
            }
        }
    }
}