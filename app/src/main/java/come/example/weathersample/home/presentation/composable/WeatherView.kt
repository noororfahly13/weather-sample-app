package come.example.weathersample.home.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import come.example.weathersample.home.domain.model.Weather
import java.util.*

@OptIn(ExperimentalUnitApi::class)
@Composable
fun WeatherView(weather: Weather) {
    val currentLocation = "${weather.city?.firstOrNull()?.name}, ${weather.city?.firstOrNull()?.state}, ${weather.city?.firstOrNull()?.country}"
    val temp = weather.current?.temp?.toString() ?: ""
    val wind = weather.current?.humidity?.toString() ?: ""
    val humidity = weather.current?.windSpeed?.toString() ?: ""
    val main = weather.current?.weather?.firstOrNull()?.main ?: ""
    val desc = weather.current?.weather?.firstOrNull()?.description?.uppercase(Locale.getDefault()) ?: ""
    val icon = weather.current?.weather?.firstOrNull()?.icon
    Column(Modifier.padding(32.dp)) {
        Text(text = currentLocation, fontSize = TextUnit(18F, TextUnitType.Sp), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(4.dp))
        icon?.let {
            Image(
                modifier = Modifier.fillMaxWidth(),
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
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(R.string.temp_celsius, temp),
            fontSize = TextUnit(24F, TextUnitType.Sp),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = main, fontSize = TextUnit(14F, TextUnitType.Sp), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = desc)
        Text(text = stringResource(R.string.temp_description, temp), fontSize = TextUnit(14F, TextUnitType.Sp))
        Text(text = stringResource(R.string.wind_speed, wind), fontSize = TextUnit(14F, TextUnitType.Sp))
        Text(text = stringResource(R.string.humidity, humidity), fontSize = TextUnit(14F, TextUnitType.Sp))
        icon?.let {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(mapTempToImage(it)),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
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