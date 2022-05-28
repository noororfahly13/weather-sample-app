package come.example.weathersample.home.data.repository

import come.example.core.NetworkBoundResource
import come.example.core.Resource
import come.example.core.network.response.ApiResponse
import come.example.weathersample.home.data.data_source.HomeLocalDataSource
import come.example.weathersample.home.data.data_source.HomeRemoteDataSource
import come.example.weathersample.home.data.entity.WeatherEntity
import come.example.weathersample.home.data.toModel
import come.example.weathersample.home.domain.model.Weather
import come.example.weathersample.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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
                }
            }
        }.asFlowData()
    }

}

