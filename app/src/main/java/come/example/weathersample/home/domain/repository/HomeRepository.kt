package come.example.weathersample.home.domain.repository

import come.example.core.Resource
import come.example.weathersample.home.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getCurrentLocationWeather(lat: Double, lng: Double): Flow<Resource<Weather?>>
}