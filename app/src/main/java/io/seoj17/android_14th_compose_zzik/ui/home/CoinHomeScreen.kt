package io.seoj17.android_14th_compose_zzik.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CoinHomeScreen(
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.align(alignment = Alignment.Center),
            text = "메인 화면"
        )
    }
}