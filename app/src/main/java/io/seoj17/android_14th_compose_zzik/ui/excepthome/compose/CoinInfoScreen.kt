package io.seoj17.android_14th_compose_zzik.ui.excepthome.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CoinInfoRoute(
    modifier: Modifier = Modifier
) {
    CoinInfoScreen()
}

@Composable
private fun CoinInfoScreen() {
    Text(text = "coin info")
}
