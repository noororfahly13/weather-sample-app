package come.example.weathersample.di

import come.example.weathersample.home.data.data_source.HomeRemoteDataSource
import come.example.weathersample.home.data.data_source.HomeRemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<HomeRemoteDataSource> { HomeRemoteDataSourceImpl(get()) }
}