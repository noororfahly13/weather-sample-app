package come.example.weathersample.home.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import come.example.core.network.constants.ConnectionEndPoint
import come.example.weathersample.R
import come.example.weathersample.home.domain.model.DailyWeather
import come.example.weathersample.home.domain.model.Weather
import java.util.*

@OptIn(ExperimentalUnitApi::class)
@Composable
fun WeatherView(weather: Weather) {
    val currentLocation = "${weather.city?.firstOrNull()?.name}, ${weather.city?.firstOrNull()?.state}, ${weather.city?.firstOrNull()?.country}"
    val temp = weather.current?.temp?.toString() ?: ""
    val wind = weather.current?.windSpeed?.toString() ?: ""
    val humidity = weather.current?.humidity?.toString() ?: ""
    val main = weather.current?.weather?.firstOrNull()?.main ?: ""
    val desc = weather.current?.weather?.firstOrNull()?.description?.uppercase(Locale.getDefault()) ?: ""
    val icon = weather.current?.weather?.firstOrNull()?.icon
    Column() {
        Text(text = currentLocation, fontSize = TextUnit(16F, TextUnitType.Sp), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        icon?.let {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(ConnectionEndPoint.IMAGE + "${it}@4x.png").apply(block = fun ImageRequest.Builder.() {
                        crossfade(true)
                        scale(Scale.FILL)
                    }).build()
                ),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }
        Text(
            text = stringResource(R.string.temp_celsius, temp),
            fontSize = TextUnit(20F, TextUnitType.Sp),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = main, fontSize = TextUnit(14F, TextUnitType.Sp), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = desc, modifier = Modifier.padding(start = 32.dp))
        Text(text = stringResource(R.string.temp_description, temp), fontSize = TextUnit(10F, TextUnitType.Sp), modifier = Modifier.padding(start = 32.dp))
        Text(text = stringResource(R.string.wind_speed, wind), fontSize = TextUnit(10F, TextUnitType.Sp), modifier = Modifier.padding(start = 32.dp))
        Text(text = stringResource(R.string.humidity, humidity), fontSize = TextUnit(10F, TextUnitType.Sp), modifier = Modifier.padding(start = 32.dp))
        icon?.let {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                painter = painterResource(mapTempToImage(it)),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }
        weather.daily?.let {
            LazyRow(contentPadding = PaddingValues(start = 16.dp)) {
                items(weather.daily) { item: DailyWeather ->
                    DailyWeatherView(weather = item)
                }
            }
        }

    }
}

private fun mapTempToImage(iconCode: String?): Int {
    return when (iconCode) {
        "01d", "02d", "03d" -> R.drawable.sunny_day
        "04d", "09d", "10d", "11d" -> R.drawable.raining
        "13d", "50d" -> R.drawable.snowfalling
        else -> R.drawable.sunny_day
    }
}