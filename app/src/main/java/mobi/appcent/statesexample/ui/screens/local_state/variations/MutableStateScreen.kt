package mobi.appcent.statesexample.ui.screens.local_state.variations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import mobi.appcent.statesexample.ui.theme.StatesExampleTheme
import kotlin.time.Duration.Companion.seconds

// Define a class that has no mutable state, so the
// composable does not accidentally react to the
// change. This is only defined to track down
// how many times the code in the screen, a.k.a
// the "Text" is called.
private class Values(
    var calledTimes: Int = 0
)

@Composable
fun MutableStateScreen() {

    // The value that the sub-screen will react to
    var stateValue: Int by remember { mutableIntStateOf(0) }

    // The internal value that does not trigger anything upon update
    // by itself
    val values: Values = remember { Values() }

    // Start a timer to update
    LaunchedEffect(key1 = Unit) {
        while (isActive) {
            delay(1.seconds)
            stateValue++
        }
    }

    // Main content
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
    ) {
        val mainScreenCalledTimes = ++(values.calledTimes)
        Text(text = "Main screen text changed: $mainScreenCalledTimes")
        AnotherComposable()
        SubComposable { stateValue } // value is read inside the lambda
    }
}

private var anotherComposableCount = 0

@Composable
private fun AnotherComposable() {
    Text(text = "Another composable text changed: ${++anotherComposableCount}")
}

@Composable
private fun SubComposable(changedStateValue: () -> Int) {
    Text(text = "Sub composable text changed: ${changedStateValue()}")
}

@Preview
@Composable
private fun DelegatedStateScreenPreview() {
    StatesExampleTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DelegatedStateScreen()
        }
    }
}