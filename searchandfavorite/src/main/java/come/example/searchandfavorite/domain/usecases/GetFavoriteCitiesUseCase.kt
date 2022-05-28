package come.example.searchandfavorite.domain.usecases

import come.example.searchandfavorite.domain.model.FavoriteCity
import come.example.searchandfavorite.domain.repository.SearchAndFavoriteRepository

class GetFavoriteCitiesUseCase(private val repository: SearchAndFavoriteRepository) {
    suspend operator fun invoke(): List<FavoriteCity> {
        return repository.getFavoriteCities()
    }
}