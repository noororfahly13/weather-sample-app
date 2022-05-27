package come.example.weathersample.home.presentation


import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import come.example.weathersample.ui.theme.AppContentColor
import come.example.weathersample.ui.theme.AppThemeColor
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    // get HomeViewModel instance from koin
    viewModel: HomeViewModel = getViewModel(),
) {

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.AppThemeColor

    val state = HomeScreenState.Idle

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }

    Scaffold(
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        contentColor = MaterialTheme.colors.AppContentColor,
        topBar = {
        },
        content = {
            when (state) {
//                is HomeScreenState.Data -> Text("Data")
//                is HomeScreenState.Error -> Text("Error: ${(state as HomeScreenState.Error).error}")
                HomeScreenState.Idle -> Text("Idle")
//                HomeScreenState.Loading -> {
//                    CircularProgressIndicator()
//                }
            }
        }
    )
}

