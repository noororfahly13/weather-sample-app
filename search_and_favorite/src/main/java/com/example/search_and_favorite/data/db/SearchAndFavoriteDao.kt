package com.example.search_and_favorite.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.search_and_favorite.data.entity.FavoriteCityEntity

@Dao
interface SearchAndFavoriteDao {

    @Query("SELECT * FROM FavoriteCityEntity WHERE name = :name LIMIT 1")
    suspend fun getFavoriteCity(name: String): FavoriteCityEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteCity(favoriteCityEntity: FavoriteCityEntity)

    @Query("SELECT * FROM FavoriteCityEntity")
    suspend fun getFavoriteCities(): List<FavoriteCityEntity>


}
