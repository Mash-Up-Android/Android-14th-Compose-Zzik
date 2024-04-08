package io.seoj17.android_14th_compose_zzik.ui.home.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier
) {
    HomeScreen()
}

@Composable
private fun HomeScreen() {
    Text(text = "home")
}