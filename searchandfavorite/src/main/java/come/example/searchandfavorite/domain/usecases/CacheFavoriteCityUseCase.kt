package come.example.searchandfavorite.domain.usecases

import come.example.searchandfavorite.domain.model.FavoriteCity
import come.example.searchandfavorite.domain.repository.SearchAndFavoriteRepository

class CacheFavoriteCityUseCase(private val repository: SearchAndFavoriteRepository) {
    suspend operator fun invoke(favoriteCity: FavoriteCity) {
        return repository.cacheFavoriteCity(favoriteCity)
    }
}