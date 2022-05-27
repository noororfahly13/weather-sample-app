package come.example.weathersample.di

import come.example.weathersample.home.data.data_source.HomeLocalDataSource
import come.example.weathersample.home.data.data_source.HomeLocalDataSourceImpl
import org.koin.dsl.module

val localSataSourceModule = module {
    single<HomeLocalDataSource> { HomeLocalDataSourceImpl(get()) }
}