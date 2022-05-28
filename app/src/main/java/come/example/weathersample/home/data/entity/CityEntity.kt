package come.example.weathersample.home.data.entity

import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(primaryKeys = ["name"])
data class CityEntity(
    @Json(name = "name")
    val name: String?,
    @Json(name = "state")
    val state: String?,
    @Json(name = "country")
    val country: String?,
)