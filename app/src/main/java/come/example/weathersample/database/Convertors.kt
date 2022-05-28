package come.example.weathersample.database

import android.text.TextUtils
import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import come.example.weathersample.home.data.entity.CityEntity
import come.example.weathersample.home.data.entity.CurrentWeatherEntity
import come.example.weathersample.home.data.entity.DailyWeatherEntity
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

    @TypeConverter
    fun fromJsonCity(string: String): CityEntity? {
        if (TextUtils.isEmpty(string))
            return null

        val jsonAdapter = moshi.adapter(CityEntity::class.java)
        return jsonAdapter.fromJson(string)
    }

    @TypeConverter
    fun toJson(data: CityEntity): String {
        val jsonAdapter = moshi.adapter(CityEntity::class.java)
        return jsonAdapter.toJson(data)
    }

    @TypeConverter
    fun fromJsonCityList(string: String): List<CityEntity>? {
        if (TextUtils.isEmpty(string))
            return null
        val type = Types.newParameterizedType(List::class.java, CityEntity::class.java)
        val jsonAdapter = moshi.adapter<List<CityEntity>>(type)
        return jsonAdapter.fromJson(string)
    }

    @TypeConverter
    fun toJsonCity(data: List<CityEntity>): String {
        val type = Types.newParameterizedType(List::class.java, CityEntity::class.java)
        val jsonAdapter = moshi.adapter<List<CityEntity>>(type)
        return jsonAdapter.toJson(data)
    }

    @TypeConverter
    fun fromJsonDailyList(string: String): List<DailyWeatherEntity>? {
        if (TextUtils.isEmpty(string))
            return null
        val type = Types.newParameterizedType(List::class.java, DailyWeatherEntity::class.java)
        val jsonAdapter = moshi.adapter<List<DailyWeatherEntity>>(type)
        return jsonAdapter.fromJson(string)
    }

    @TypeConverter
    fun toJsonDaily(data: List<DailyWeatherEntity>): String {
        val type = Types.newParameterizedType(List::class.java, DailyWeatherEntity::class.java)
        val jsonAdapter = moshi.adapter<List<DailyWeatherEntity>>(type)
        return jsonAdapter.toJson(data)
    }
}