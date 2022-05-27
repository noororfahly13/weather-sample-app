package come.example.weathersample.home.domain.usecases

import come.example.core.Resource
import come.example.weathersample.home.domain.model.Weather
import come.example.weathersample.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GetCurrentLocationWeather(private val repository: HomeRepository) {
    operator fun invoke(lat: Double, lng: Double): Flow<Resource<Weather>> {
        return flow { emit(Resource.loading<Weather>()) }
    }
}