package come.example.weathersample.home.data.repository

import come.example.weathersample.home.data.data_source.HomeLocalDataSource
import come.example.weathersample.home.data.data_source.HomeRemoteDataSource
import come.example.weathersample.home.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val localDataSource: HomeLocalDataSource,
    private val remoteDataSource: HomeRemoteDataSource,
) : HomeRepository {

}

