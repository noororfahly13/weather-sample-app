package come.example.searchandfavorite.data.data_source

import come.example.core.network.response.ApiResponse
import come.example.searchandfavorite.data.api.SearchAndFavoriteService
import come.example.searchandfavorite.data.entity.CityWeatherEntity


interface SearchAndFavoriteRemoteDataSource {
    suspend fun getCityWeather(name: String): ApiResponse<CityWeatherEntity>
}

class SearchAndFavoriteRemoteDataSourceImpl(
    private val service: SearchAndFavoriteService
) : SearchAndFavoriteRemoteDataSource {

    override suspend fun getCityWeather(name: String): ApiResponse<CityWeatherEntity> {
        return service.fetchWeatherForCity(name)
    }

}