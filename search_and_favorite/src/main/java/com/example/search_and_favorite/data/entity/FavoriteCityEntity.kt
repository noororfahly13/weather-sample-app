package com.example.search_and_favorite.data.entity

import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(primaryKeys = ["name"])
data class FavoriteCityEntity(
    @Json(name = "name")
    val name: String,
)