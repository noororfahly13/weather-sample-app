package come.example.searchandfavorite.domain.usecases

import come.example.core.Resource
import come.example.searchandfavorite.domain.model.CityWeather
import come.example.searchandfavorite.domain.repository.SearchAndFavoriteRepository
import kotlinx.coroutines.flow.Flow

class GetCityWeatherUseCase(private val repository: SearchAndFavoriteRepository) {
    operator fun invoke(name: String): Flow<Resource<CityWeather?>> {
        return repository.getCityWeather(name)
    }
}