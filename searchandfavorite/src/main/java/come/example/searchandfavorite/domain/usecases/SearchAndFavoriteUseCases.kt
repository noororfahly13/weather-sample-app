package come.example.searchandfavorite.domain.usecases

data class SearchAndFavoriteUseCases(
    val getCityWeatherUseCase: GetCityWeatherUseCase,
    val cacheFavoriteCityUseCase: CacheFavoriteCityUseCase,
    val getFavoriteCitiesUseCase: GetFavoriteCitiesUseCase,
    val checkCityFavoriteUseCase: CheckCityFavoriteUseCase
)
