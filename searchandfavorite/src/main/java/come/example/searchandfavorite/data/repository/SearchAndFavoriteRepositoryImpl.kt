package come.example.searchandfavorite.data.repository

import come.example.core.OnlineNetworkBoundResource
import come.example.core.Resource
import come.example.core.network.response.ApiResponse
import come.example.searchandfavorite.data.data_source.SearchAndFavoriteLocalDataSource
import come.example.searchandfavorite.data.data_source.SearchAndFavoriteRemoteDataSource
import come.example.searchandfavorite.data.entity.CityWeatherEntity
import come.example.searchandfavorite.data.toEntity
import come.example.searchandfavorite.data.toModel
import come.example.searchandfavorite.domain.model.CityWeather
import come.example.searchandfavorite.domain.model.FavoriteCity
import come.example.searchandfavorite.domain.repository.SearchAndFavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

class SearchAndFavoriteRepositoryImpl(
    private val localDataSource: SearchAndFavoriteLocalDataSource,
    private val remoteDataSource: SearchAndFavoriteRemoteDataSource,
) : SearchAndFavoriteRepository {

    override fun getCityWeather(name: String): Flow<Resource<CityWeather?>> {
        return object :
            OnlineNetworkBoundResource<CityWeather?, CityWeatherEntity>() {

            override fun onFetchFailed() {
                Timber.e("Fetch Failed")
            }

            override suspend fun createCall(): Flow<ApiResponse<CityWeatherEntity>?> {
                return flow {
                    emit(remoteDataSource.getCityWeather(name))
                }
            }

            override suspend fun convertResult(data: CityWeatherEntity): CityWeather {
                return data.toModel()
            }
        }.asFlowData()

    }

    override suspend fun getFavoriteCities(): List<FavoriteCity> {
        return localDataSource.getFavoriteCities()?.map { it -> it.toModel() } ?: emptyList()
    }

    override suspend fun cacheFavoriteCity(favoriteCity: FavoriteCity) {
        localDataSource.cacheFavoriteCity(favoriteCity.toEntity())
    }

    override suspend fun isCityFavorite(name: String): Boolean {
        return localDataSource.isCityFavorite(name)
    }
}

