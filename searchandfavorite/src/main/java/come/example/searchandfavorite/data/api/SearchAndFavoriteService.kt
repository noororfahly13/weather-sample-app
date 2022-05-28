package come.example.searchandfavorite.data.api

import come.example.core.network.constants.ConnectionEndPoint
import come.example.core.network.response.ApiResponse
import come.example.searchandfavorite.data.entity.CityWeatherEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAndFavoriteService {

    @GET(ConnectionEndPoint.WEATHER)
    suspend fun fetchWeatherForCity(@Query("q") name: String?): ApiResponse<CityWeatherEntity>

}