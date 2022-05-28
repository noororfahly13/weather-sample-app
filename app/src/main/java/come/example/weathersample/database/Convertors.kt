package come.example.weathersample.database

import android.text.TextUtils
import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import come.example.weathersample.home.data.entity.CurrentWeatherEntity
import come.example.weathersample.home.data.entity.WeatherDetailsEntity


open class Convertors {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromJsonWeatherDetails(string: String): WeatherDetailsEntity? {
        if (TextUtils.isEmpty(string))
            return null

        val jsonAdapter = moshi.adapter(WeatherDetailsEntity::class.java)
        return jsonAdapter.fromJson(string)
    }

    @TypeConverter
    fun toJson(data: WeatherDetailsEntity): String {
        val jsonAdapter = moshi.adapter(WeatherDetailsEntity::class.java)
        return jsonAdapter.toJson(data)
    }

    @TypeConverter
    fun fromJsonCurrentWeather(string: String): CurrentWeatherEntity? {
        if (TextUtils.isEmpty(string))
            return null

        val jsonAdapter = moshi.adapter(CurrentWeatherEntity::class.java)
        return jsonAdapter.fromJson(string)
    }

    @TypeConverter
    fun toJson(data: CurrentWeatherEntity): String {
        val jsonAdapter = moshi.adapter(CurrentWeatherEntity::class.java)
        return jsonAdapter.toJson(data)
    }
}