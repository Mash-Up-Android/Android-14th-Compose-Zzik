package io.seoj17.android_14th_compose_zzik.ui.investment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CoinInvestmentListScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.align(alignment = Alignment.Center),
            text = "투자 내역 화면"
        )
    }
}