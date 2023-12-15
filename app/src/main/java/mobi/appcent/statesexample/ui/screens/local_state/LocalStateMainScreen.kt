package mobi.appcent.statesexample.ui.screens.local_state

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mobi.appcent.statesexample.ui.components.RedirectButton
import mobi.appcent.statesexample.ui.Routes
import mobi.appcent.statesexample.ui.screens.local_state.variations.DelegatedStateInlineScreen
import mobi.appcent.statesexample.ui.screens.local_state.variations.DelegatedStateScreen
import mobi.appcent.statesexample.ui.screens.local_state.variations.DelegatedStateWithLambdaScreen
import mobi.appcent.statesexample.ui.screens.local_state.variations.MutableStateInlineScreen
import mobi.appcent.statesexample.ui.screens.local_state.variations.MutableStateScreen
import mobi.appcent.statesexample.ui.screens.local_state.variations.MutableStateWithLambdaScreen

/**
 * Created by Furkan Yurdakul on 14.12.2023.
 */
@Composable
fun LocalStateMainScreen() {

    val navController = rememberNavController()
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = Routes.LocalState.HOME,
        enterTransition = { fadeIn(tween(300)) },
        exitTransition = { fadeOut(tween(300)) }
    ) {
        composable(Routes.LocalState.HOME) {
            LocalStateHomeScreen(
                onMutableStateClick = {
                    navController.navigate(Routes.LocalState.MUTABLE_STATE)
                },
                onDelegatedStateClick = {
                    navController.navigate(Routes.LocalState.DELEGATED_STATE)
                },
                onMutableStateWithLambdaClick = {
                    navController.navigate(Routes.LocalState.MUTABLE_STATE_WITH_LAMBDA)
                },
                onDelegatedStateWithLambdaClick = {
                    navController.navigate(Routes.LocalState.DELEGATED_STATE_WITH_LAMBDA)
                },
                onMutableStateInlineClick = {
                    navController.navigate(Routes.LocalState.MUTABLE_STATE_INLINE)
                },
                onDelegatedStateInlineClick = {
                    navController.navigate(Routes.LocalState.DELEGATED_STATE_INLINE)
                },
            )
        }
        composable(Routes.LocalState.MUTABLE_STATE) {
            MutableStateScreen()
        }
        composable(Routes.LocalState.DELEGATED_STATE) {
            DelegatedStateScreen()
        }
        composable(Routes.LocalState.MUTABLE_STATE_WITH_LAMBDA) {
            MutableStateWithLambdaScreen()
        }
        composable(Routes.LocalState.DELEGATED_STATE_WITH_LAMBDA) {
            DelegatedStateWithLambdaScreen()
        }
        composable(Routes.LocalState.MUTABLE_STATE_INLINE) {
            MutableStateInlineScreen()
        }
        composable(Routes.LocalState.DELEGATED_STATE_INLINE) {
            DelegatedStateInlineScreen()
        }
    }
}

@Composable
private fun LocalStateHomeScreen(
    onMutableStateClick: () -> Unit,
    onDelegatedStateClick: () -> Unit,
    onMutableStateWithLambdaClick: () -> Unit,
    onDelegatedStateWithLambdaClick: () -> Unit,
    onMutableStateInlineClick: () -> Unit,
    onDelegatedStateInlineClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        RedirectButton(
            text = "Mutable State",
            onClick = onMutableStateClick
        )
        RedirectButton(
            text = "Delegated State",
            onClick = onDelegatedStateClick
        )
        RedirectButton(
            text = "Mutable State With Lambda",
            onClick = onMutableStateWithLambdaClick
        )
        RedirectButton(
            text = "Delegated State With Lambda",
            onClick = onDelegatedStateWithLambdaClick
        )
        RedirectButton(
            text = "Mutable State Inline",
            onClick = onMutableStateInlineClick
        )
        RedirectButton(
            text = "Delegated State Inline",
            onClick = onDelegatedStateInlineClick
        )
    }
}