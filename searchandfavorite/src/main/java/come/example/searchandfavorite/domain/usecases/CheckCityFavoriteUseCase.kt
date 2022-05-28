package come.example.searchandfavorite.domain.usecases

import come.example.searchandfavorite.domain.repository.SearchAndFavoriteRepository

class CheckCityFavoriteUseCase(private val repository: SearchAndFavoriteRepository) {
    suspend operator fun invoke(name: String): Boolean {
        return repository.isCityFavorite(name)
    }
}