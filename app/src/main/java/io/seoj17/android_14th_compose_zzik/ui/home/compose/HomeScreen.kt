package io.seoj17.android_14th_compose_zzik.ui.home.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.seoj17.android_14th_compose_zzik.ui.common.BitTopBar
import io.seoj17.android_14th_compose_zzik.ui.theme.BitBackgroundColor
import io.seoj17.android_14th_compose_zzik.ui.theme.BitWhiteColor

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier
) {
    HomeScreen(
        modifier = modifier
    )
}

@Composable
private fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            BitTopBar(
                title = {
                    Text(
                        text = "거래소",
                        color = BitWhiteColor
                    )
                },
                needBackBtn = false
            )
        },
        containerColor = BitBackgroundColor
    ) { innerPadding ->
        HomeContent(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun HomeContent(
    modifier: Modifier = Modifier
) {

}
