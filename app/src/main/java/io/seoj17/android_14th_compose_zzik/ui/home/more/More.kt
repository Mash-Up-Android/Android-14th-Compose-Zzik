package io.seoj17.android_14th_compose_zzik.ui.home.more

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.seoj17.android_14th_compose_zzik.R
import io.seoj17.android_14th_compose_zzik.ui.component.UpBitHeader
import io.seoj17.android_14th_compose_zzik.ui.theme.Android14thComposeZzikTheme

@Composable
fun More() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        UpBitHeader(
            title = "더보기",
            showActionButton = true,
        )
        Text(
            modifier = Modifier.align(alignment = Alignment.Center),
            text = stringResource(R.string.more)
        )
    }
}

@Composable
@Preview
private fun MorePreview() {
    Android14thComposeZzikTheme {
        More()
    }
}