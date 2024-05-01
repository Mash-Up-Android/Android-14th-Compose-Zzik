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
fun DetailRoute(
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    DetailScreen(modifier = modifier, onBackClicked = onBackClicked)
}

@Composable
fun DetailScreen(
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            BitTopBar(
                title = {
                    Text(text = "비트코인", color = BitWhiteColor)
                },
                onBackClicked = onBackClicked
            )
        },
        containerColor = BitBackgroundColor
    ) { innerPadding ->
        DetailContent(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier
) {
    
}
