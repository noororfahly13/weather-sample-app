package com.example.search_and_favorite.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.example.core.network.constants.ConnectionEndPoint
import com.example.search_and_favorite.R
import com.example.search_and_favorite.domain.model.CityWeather

@OptIn(ExperimentalUnitApi::class)
@Composable
fun CityWeatherView(weather: CityWeather, withFavoriteButton: Boolean, onFavoriteClick: () -> Unit) {
    val name = weather.name ?: ""
    val temp = weather.main?.temp?.toString() ?: ""
    val humidity = weather.main?.humidity?.toString() ?: ""
    val main = weather.weather?.firstOrNull()?.main ?: ""
    val icon = weather.weather?.firstOrNull()?.icon
    Column() {
        Spacer(modifier = Modifier.height(64.dp))
        Text(text = name, fontSize = TextUnit(16F, TextUnitType.Sp), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
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
        Text(text = stringResource(R.string.temp_description, temp), fontSize = TextUnit(14F, TextUnitType.Sp), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Text(text = stringResource(R.string.humidity, humidity), fontSize = TextUnit(14F, TextUnitType.Sp), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(64.dp))
        if (withFavoriteButton)
            Box(modifier = Modifier.padding(horizontal = 32.dp)) {
                Button(
                    onClick = { onFavoriteClick.invoke() },
                    Modifier
                        .padding(32.dp)
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colors.surface)
                ) {
                    Text(
                        text = stringResource(R.string.add_favorite),
                        fontSize = TextUnit(14F, TextUnitType.Sp),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White
                    )
                }
            }
        else
            Text(text = stringResource(R.string.favorite_city), fontSize = TextUnit(14F, TextUnitType.Sp), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(32.dp))
    }
}