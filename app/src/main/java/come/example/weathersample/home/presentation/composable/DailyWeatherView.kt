package come.example.weathersample.home.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import come.example.core.extensions.toDay
import come.example.core.network.constants.ConnectionEndPoint
import come.example.weathersample.R
import come.example.weathersample.home.domain.model.DailyWeather
import java.util.*

@OptIn(ExperimentalUnitApi::class)
@Composable
fun DailyWeatherView(weather: DailyWeather) {
    val tempMin = weather.temp?.min?.toString() ?: ""
    val tempMax = weather.temp?.min?.toString() ?: ""
    val wind = weather.windSpeed?.toString() ?: ""
    val humidity = weather.humidity?.toString() ?: ""
    val main = weather.weather?.firstOrNull()?.main ?: ""
    val desc = weather.weather?.firstOrNull()?.description?.uppercase(Locale.getDefault()) ?: ""
    val icon = weather.weather?.firstOrNull()?.icon
    val day = weather.dt?.toDay() ?: ""
    Card(modifier = Modifier.padding(8.dp), elevation = 2.dp) {
        Row(Modifier.padding(8.dp)) {
            icon?.let {
                Image(
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp),
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
            Spacer(modifier = Modifier.width(4.dp))
            Column() {
                Text(text = day, fontSize = TextUnit(14F, TextUnitType.Sp))
                Text(text = desc, fontSize = TextUnit(12F, TextUnitType.Sp))
                Text(text = stringResource(R.string.wind_speed, wind), fontSize = TextUnit(10F, TextUnitType.Sp))
                Text(text = stringResource(R.string.humidity, humidity), fontSize = TextUnit(10F, TextUnitType.Sp))
            }
            Spacer(modifier = Modifier.width(4.dp))
            Column() {
                Text(text = stringResource(R.string.temp_min, tempMin), fontSize = TextUnit(10F, TextUnitType.Sp))
                Text(text = stringResource(R.string.temp_max, tempMax), fontSize = TextUnit(10F, TextUnitType.Sp))
            }
        }
    }
}
