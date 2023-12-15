package mobi.appcent.statesexample.ui

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mobi.appcent.statesexample.ui.screens.HomeScreen
import mobi.appcent.statesexample.ui.screens.local_state.LocalStateMainScreen

/**
 * Created by Furkan Yurdakul on 14.12.2023.
 */
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = Routes.HOME,
        enterTransition = { fadeIn(tween(300)) },
        exitTransition = { fadeOut(tween(300)) }
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                onNavigateToRememberStateScreen = {
                    navController.navigate(Routes.LOCAL_STATE)
                }
            )
        }
        composable(Routes.LOCAL_STATE) { LocalStateMainScreen() }
    }
}