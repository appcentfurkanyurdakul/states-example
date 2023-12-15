package mobi.appcent.statesexample.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mobi.appcent.statesexample.ui.components.RedirectButton

/**
 * Created by Furkan Yurdakul on 14.12.2023.
 */
@Composable
fun HomeScreen(
    onNavigateToRememberStateScreen: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
    ) {
        RedirectButton(
            text = "Remember State Screen",
            onClick = onNavigateToRememberStateScreen
        )
    }
}