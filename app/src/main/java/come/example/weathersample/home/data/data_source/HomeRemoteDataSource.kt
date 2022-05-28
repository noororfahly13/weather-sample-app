package come.example.weathersample.home.data.data_source

import come.example.core.network.response.ApiResponse
import come.example.weathersample.home.data.api.HomeService
import come.example.weathersample.home.data.entity.CityEntity
import come.example.weathersample.home.data.entity.WeatherEntity


interface HomeRemoteDataSource {
    suspend fun getCurrentLocationWeather(lat: Double, lng: Double): ApiResponse<WeatherEntity>
    suspend fun getCityName(lat: Double, lng: Double): ApiResponse<List<CityEntity>>
}

class HomeRemoteDataSourceImpl(
    private val homeService: HomeService
) : HomeRemoteDataSource {
    override suspend fun getCurrentLocationWeather(lat: Double, lng: Double): ApiResponse<WeatherEntity> {
        return homeService.fetchWeatherForLocation(lat, lng)
    }

    override suspend fun getCityName(lat: Double, lng: Double): ApiResponse<List<CityEntity>> {
        return homeService.fetchCityName(lat, lng)
    }

}