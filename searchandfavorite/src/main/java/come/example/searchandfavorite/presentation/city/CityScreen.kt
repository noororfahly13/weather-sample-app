package come.example.searchandfavorite.presentation.city

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import come.example.core.common_ui.CenteredView
import come.example.searchandfavorite.R
import come.example.searchandfavorite.presentation.composable.CityWeatherView
import org.koin.androidx.compose.getViewModel

@Composable
fun CityScreen(
    navController: NavHostController,
    name: String,
    viewModel: CityViewModel = getViewModel(),
) {
    val cityState by viewModel.cityState.collectAsState()
    val isCityFavoriteState by viewModel.cityFavoriteState.collectAsState()

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = name) {
        viewModel.updateCity(name)
        viewModel.isCityFavorite(name)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { scaffoldState.snackbarHostState },
        topBar = {
        },
        content = {
            when (cityState) {
                is CityScreenState.Data ->
                    CityWeatherView((cityState as CityScreenState.Data).weather, !isCityFavoriteState) {
                        viewModel.cacheFavoriteCity(name)
                    }
                is CityScreenState.Error -> CenteredView { Text("Error: ${(cityState as CityScreenState.Error).error}") }
                is CityScreenState.Idle, CityScreenState.Loading -> CenteredView { CircularProgressIndicator() }
                is CityScreenState.NoCityLocation -> CenteredView { Text(stringResource(id = R.string.no_current_location)) }
            }
        }
    )
}

