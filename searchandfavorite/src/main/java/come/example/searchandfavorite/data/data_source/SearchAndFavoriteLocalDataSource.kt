package come.example.searchandfavorite.data.data_source

import come.example.searchandfavorite.data.db.SearchAndFavoriteDao
import come.example.searchandfavorite.data.entity.FavoriteCityEntity


interface SearchAndFavoriteLocalDataSource {
    suspend fun getFavoriteCities(): List<FavoriteCityEntity>?
    suspend fun cacheFavoriteCity(favoriteCityEntity: FavoriteCityEntity)
    suspend fun isCityFavorite(name: String): Boolean
}

class SearchAndFavoriteLocalDataSourceImpl(private val dao: SearchAndFavoriteDao) : SearchAndFavoriteLocalDataSource {
    override suspend fun getFavoriteCities(): List<FavoriteCityEntity>? {
        return dao.getFavoriteCities()
    }

    override suspend fun cacheFavoriteCity(favoriteCityEntity: FavoriteCityEntity) {
        return dao.insertFavoriteCity(favoriteCityEntity)
    }

    override suspend fun isCityFavorite(name: String): Boolean {
        return dao.getFavoriteCity(name) != null
    }

}