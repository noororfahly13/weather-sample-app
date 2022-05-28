package com.example.search_and_favorite.data.repository

import com.example.core.OnlineNetworkBoundResource
import com.example.core.Resource
import com.example.core.network.response.ApiResponse
import com.example.search_and_favorite.data.data_source.SearchAndFavoriteLocalDataSource
import com.example.search_and_favorite.data.data_source.SearchAndFavoriteRemoteDataSource
import com.example.search_and_favorite.data.entity.CityWeatherEntity
import com.example.search_and_favorite.data.toEntity
import com.example.search_and_favorite.data.toModel
import com.example.search_and_favorite.domain.model.CityWeather
import com.example.search_and_favorite.domain.model.FavoriteCity
import com.example.search_and_favorite.domain.repository.SearchAndFavoriteRepository
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

    override suspend fun removeFavoriteCity(favoriteCity: FavoriteCity) {
        localDataSource.removeFavoriteCity(favoriteCity.toEntity())
    }
}

