package come.example.weathersample.home.data.entity

import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(primaryKeys = ["id"])
data class WeatherEntity(
    @Json(name = "id")
    val id: Int,
)