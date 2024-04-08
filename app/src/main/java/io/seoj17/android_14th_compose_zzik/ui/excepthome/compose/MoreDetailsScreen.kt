package io.seoj17.android_14th_compose_zzik.ui.excepthome.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MoreDetailsRoute(
    modifier: Modifier = Modifier
) {
    MoreDetailsScreen()
}

@Composable
private fun MoreDetailsScreen() {
    Text(text = "more details")
}
