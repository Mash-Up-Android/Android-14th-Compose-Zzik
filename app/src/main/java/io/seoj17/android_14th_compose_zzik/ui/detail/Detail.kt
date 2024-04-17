package io.seoj17.android_14th_compose_zzik.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.seoj17.android_14th_compose_zzik.ui.component.UpBitTopBar
import io.seoj17.android_14th_compose_zzik.ui.theme.Android14thComposeZzikTheme

@Composable
fun Detail(
    title: String,
    onBackPressed: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        UpBitTopBar(
            title = title,
            onBackButtonClick = { onBackPressed() },
        )
    }
}

@Composable
@Preview
fun DetailPreview() {
    Android14thComposeZzikTheme {
        Detail(
            "도지코인(DOGE/KRW)",
            {},
        )
    }
}
