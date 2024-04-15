package io.seoj17.android_14th_compose_zzik.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.seoj17.android_14th_compose_zzik.ui.theme.Android14thComposeZzikTheme
import io.seoj17.android_14th_compose_zzik.ui.theme.Gray

private val HeaderHeight = 56.dp

@Composable
fun UpBitHeader(
    modifier: Modifier = Modifier,
    title: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(HeaderHeight),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp),
            text = title,
            color = Gray,
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
@Preview
private fun UpBitHeaderPreview() {
    Android14thComposeZzikTheme {
        UpBitHeader(
            title = "거래소",
        )
    }
}
