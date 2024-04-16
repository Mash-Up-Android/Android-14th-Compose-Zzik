package io.seoj17.android_14th_compose_zzik.ui.home.exchange

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.seoj17.android_14th_compose_zzik.R
import io.seoj17.android_14th_compose_zzik.ui.component.UpBitHeader
import io.seoj17.android_14th_compose_zzik.ui.component.UpBitSearchBar
import io.seoj17.android_14th_compose_zzik.ui.theme.Android14thComposeZzikTheme

@Composable
fun Exchange() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        UpBitHeader(title = stringResource(R.string.exchange))
        UpBitSearchBar(hint = stringResource(id = R.string.exchange_search_hint))
    }
}

@Composable
@Preview
private fun ExchangePreview() {
    Android14thComposeZzikTheme {
        Exchange()
    }
}
