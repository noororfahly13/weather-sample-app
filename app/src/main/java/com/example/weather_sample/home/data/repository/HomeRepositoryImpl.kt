package com.example.weather_sample.home.data.repository

import com.example.core.NetworkBoundResource
import com.example.core.Resource
import com.example.core.network.response.ApiResponse
import com.example.core.network.response.ApiSuccessResponse
import com.example.weather_sample.home.data.data_source.HomeLocalDataSource
import com.example.weather_sample.home.data.data_source.HomeRemoteDataSource
import com.example.weather_sample.home.data.entity.WeatherEntity
import com.example.weather_sample.home.data.toModel
import com.example.weather_sample.home.domain.model.Weather
import com.example.weather_sample.home.domain.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import timber.log.Timber

class HomeRepositoryImpl(
    private val localDataSource: HomeLocalDataSource,
    private val remoteDataSource: HomeRemoteDataSource,
) : HomeRepository {
    override fun getCurrentLocationWeather(lat: Double, lng: Double): Flow<Resource<Weather?>> {
        return object :
            NetworkBoundResource<Weather?, WeatherEntity>() {

            override fun onFetchFailed() {
                Timber.e("Fetch Failed")
            }

            override fun shouldFetch(data: Weather?) = true

            override suspend fun saveCallResult(item: WeatherEntity) {
                localDataSource.cacheCurrentLocationWeather(item)
            }

            override suspend fun loadFromDb(): Weather? {
                val res = localDataSource.getCachedCurrentLocationWeather(lat, lng)?.toModel()
                Timber.v("noor $res")
                return localDataSource.getCachedCurrentLocationWeather(lat, lng)?.toModel()
            }

            override suspend fun createCall(): Flow<ApiResponse<WeatherEntity>?> {
                return flow {
                    emit(remoteDataSource.getCurrentLocationWeather(lat, lng))
                }.zip(flow {
                    emit(remoteDataSource.getCityName(lat, lng))
                }) { weather, city ->
                    if (weather.isSuccessful() && city.isSuccessful() && weather is ApiSuccessResponse && city is ApiSuccessResponse)
                        weather.body.city = city.body
                    return@zip weather
                }.flowOn(Dispatchers.Default)
                    .catch { e ->
                        emit(ApiResponse.create(e))
                    }
            }
        }.asFlowData()
    }

}

