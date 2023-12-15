package mobi.appcent.statesexample.ui.screens.local_state.variations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlin.time.Duration.Companion.seconds

private var calledTimes = 0

/**
 * Created by Furkan Yurdakul on 14.12.2023.
 */
@Composable
fun DelegatedStateWithLambdaScreen() {

    var stateValue: Int by remember { mutableIntStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        while (isActive) {
            delay(1.seconds)
            stateValue++
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
    ) {
        val mainScreenCalledTimes = ++calledTimes
        Text(text = "Main screen text changed: $mainScreenCalledTimes")
        SubComposable { stateValue }
    }
}

@Composable
private fun SubComposable(changedStateValue: () -> Int) {
    Text(text = "Sub composable text changed: ${changedStateValue()}")
}