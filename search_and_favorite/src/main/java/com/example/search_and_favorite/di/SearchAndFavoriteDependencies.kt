package com.example.search_and_favorite.di

import com.example.search_and_favorite.data.data_source.SearchAndFavoriteLocalDataSource
import com.example.search_and_favorite.data.data_source.SearchAndFavoriteLocalDataSourceImpl
import com.example.search_and_favorite.data.data_source.SearchAndFavoriteRemoteDataSource
import com.example.search_and_favorite.data.data_source.SearchAndFavoriteRemoteDataSourceImpl
import com.example.search_and_favorite.data.repository.SearchAndFavoriteRepositoryImpl
import com.example.search_and_favorite.domain.repository.SearchAndFavoriteRepository
import com.example.search_and_favorite.domain.usecases.*
import com.example.search_and_favorite.presentation.city.CityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchAndFavoriteModule = module {
    single<SearchAndFavoriteLocalDataSource> { SearchAndFavoriteLocalDataSourceImpl(get()) }
    single<SearchAndFavoriteRemoteDataSource> { SearchAndFavoriteRemoteDataSourceImpl(get()) }
    single<SearchAndFavoriteRepository> { SearchAndFavoriteRepositoryImpl(get(), get()) }
    single { GetCityWeatherUseCase(get()) }
    single { GetFavoriteCitiesUseCase(get()) }
    single { CacheFavoriteCityUseCase(get()) }
    single { CheckCityFavoriteUseCase(get()) }
    single { SearchAndFavoriteUseCases(get(), get(), get(), get()) }
    viewModel { CityViewModel(get()) }
}