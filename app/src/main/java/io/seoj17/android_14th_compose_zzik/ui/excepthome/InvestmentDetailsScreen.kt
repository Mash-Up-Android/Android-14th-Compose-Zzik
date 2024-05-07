package io.seoj17.android_14th_compose_zzik.ui.excepthome

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InvestmentDetailsRoute(
    modifier: Modifier = Modifier
) {
    InvestmentDetailsScreen()
}

@Composable
private fun InvestmentDetailsScreen() {
    Text(text = "investment details")
}
