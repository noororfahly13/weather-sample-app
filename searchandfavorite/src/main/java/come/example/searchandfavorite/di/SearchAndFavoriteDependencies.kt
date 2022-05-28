package come.example.searchandfavorite.di

import come.example.searchandfavorite.data.data_source.SearchAndFavoriteLocalDataSource
import come.example.searchandfavorite.data.data_source.SearchAndFavoriteLocalDataSourceImpl
import come.example.searchandfavorite.data.data_source.SearchAndFavoriteRemoteDataSource
import come.example.searchandfavorite.data.data_source.SearchAndFavoriteRemoteDataSourceImpl
import come.example.searchandfavorite.data.repository.SearchAndFavoriteRepositoryImpl
import come.example.searchandfavorite.domain.repository.SearchAndFavoriteRepository
import come.example.searchandfavorite.domain.usecases.*
import come.example.searchandfavorite.presentation.city.CityViewModel
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