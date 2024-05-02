package io.seoj17.android_14th_compose_zzik.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.seoj17.android_14th_compose_zzik.ui.theme.BitMainColor
import io.seoj17.android_14th_compose_zzik.ui.theme.BitWhiteColor

@Composable
fun BitDetailTab(
    modifier: Modifier = Modifier,
) {
    val tabData = listOf("주문", "호가", "차트", "시세", "정보")
    LazyRow(
        modifier = modifier.fillMaxWidth().background(BitMainColor),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        itemsIndexed(tabData) { idx, text ->
            BitDetail(
                text = text,
                color = BitWhiteColor,
                onClick = {}
            )
        }
    }
}

@Composable
fun BitDetail(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onClick() }
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            text = text,
            color = color
        )
    }
}
