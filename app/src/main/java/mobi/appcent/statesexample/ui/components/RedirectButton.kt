package mobi.appcent.statesexample.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * Created by Furkan Yurdakul on 14.12.2023.
 */
@Composable
fun RedirectButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = text)
    }
}