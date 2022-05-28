package come.example.weathersample.home.data.api

import come.example.core.network.constants.ConnectionEndPoint
import come.example.core.network.response.ApiResponse
import come.example.weathersample.home.data.entity.WeatherEntity
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * REST API access points
 */
interface HomeService {

    @GET(ConnectionEndPoint.ONE_CALL)
    suspend fun fetchWeatherForLocation(@Query("lat") lat: Double?, @Query("lon") lng: Double?): ApiResponse<WeatherEntity>
}