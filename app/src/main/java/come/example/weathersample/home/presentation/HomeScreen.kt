package come.example.weathersample.home.presentation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.freelapp.locationfetcher.compose.LocalLocationFetcher
import com.freelapp.locationfetcher.compose.LocationFetcher
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
import come.example.weathersample.R
import come.example.weathersample.home.presentation.composable.CenteredView
import come.example.weathersample.home.presentation.composable.WeatherView
import come.example.weathersample.ui.theme.AppContentColor
import come.example.weathersample.ui.theme.AppThemeColor
import org.koin.androidx.compose.getViewModel
import kotlin.time.Duration.Companion.seconds

@Composable
fun HomeScreen(
    navController: NavHostController,
    // get HomeViewModel instance from koin
    viewModel: HomeViewModel = getViewModel(),
) {
    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.AppThemeColor
    val scaffoldState = rememberScaffoldState()
    val homeState by viewModel.homeState.collectAsState()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }

    Scaffold(
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        contentColor = MaterialTheme.colors.AppContentColor,
        scaffoldState = scaffoldState,
        snackbarHost = { scaffoldState.snackbarHostState },
        topBar = {
        },
        content = {
            LocationFetcher(
                requestConfig = {
                    interval = 15.seconds.inWholeMilliseconds
                    fastestInterval = 15.seconds.inWholeMilliseconds
                    priority = PRIORITY_HIGH_ACCURACY
                },
                rationale = stringResource(id = R.string.permission_location_rationale),
            ) {
                val locationResult = LocalLocationFetcher.current.locationResult
                viewModel.updateCurrentLocation(locationResult?.lastLocation?.latitude, locationResult?.lastLocation?.longitude)
                when (homeState) {
                    is HomeScreenState.Data -> CenteredView { WeatherView((homeState as HomeScreenState.Data).weather) }
                    is HomeScreenState.Error -> CenteredView { Text("Error: ${(homeState as HomeScreenState.Error).error}") }
                    is HomeScreenState.Idle, HomeScreenState.Loading -> CenteredView { CircularProgressIndicator() }
                    is HomeScreenState.NoCurrentLocation -> CenteredView { Text(stringResource(id = R.string.no_current_location)) }
                }
            }
        }
    )
}

