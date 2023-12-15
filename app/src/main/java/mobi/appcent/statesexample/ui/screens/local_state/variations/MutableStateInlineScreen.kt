package mobi.appcent.statesexample.ui.screens.local_state.variations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
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
fun MutableStateInlineScreen() {

    val stateValue: MutableState<Int> = remember { mutableIntStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        while (isActive) {
            delay(1.seconds)
            stateValue.value++
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
    ) {
        val mainScreenCalledTimes = ++calledTimes
        Text(text = "Main screen text changed: $mainScreenCalledTimes")
        SubComposable(stateValue)
    }
}

@Composable
private inline fun SubComposable(changedStateValue: State<Int>) {
    Text(text = "Sub composable text changed: ${changedStateValue.value}")
}