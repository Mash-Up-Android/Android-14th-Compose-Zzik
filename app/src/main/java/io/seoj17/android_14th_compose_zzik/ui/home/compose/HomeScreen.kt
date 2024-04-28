package io.seoj17.android_14th_compose_zzik.ui.home.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.seoj17.android_14th_compose_zzik.ui.common.BitTextField
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
    Column(modifier = modifier) {
        var text by remember { mutableStateOf("") }
        BitTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChanged = { text = it },
            hint = "코인명/심볼 검색",
            fontSize = 16,
            maxLength = 100,
        )
        Divider(modifier = Modifier.padding(6.dp), color = BitWhiteColor)
    }
}
