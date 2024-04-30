package io.seoj17.android_14th_compose_zzik.ui.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.seoj17.android_14th_compose_zzik.ui.theme.BitBlueColor
import io.seoj17.android_14th_compose_zzik.ui.theme.BitWhiteColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BitUnitTabPager(
    modifier: Modifier = Modifier
) {
    val tabData = listOf("KRW", "BTC", "USDT")
    val pagerState = rememberPagerState { tabData.size }
    val coroutineScope = rememberCoroutineScope()

    Row(modifier = modifier) {
        tabData.forEachIndexed { idx, text ->
            BitUnit(
                text = text,
                color = if (pagerState.currentPage == idx) BitBlueColor else BitWhiteColor.copy(alpha = 0.5f),
                onClick = {
                    coroutineScope.launch {
                        pagerState.scrollToPage(idx)
                    }
                }
            )
        }
    }
    HorizontalPager(state = pagerState) { idx ->  
        Column {
            Text(text = tabData[idx])
        }
    }
}

@Composable
private fun BitUnit(
    text: String,
    color: Color,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(1.dp, color)
            .clickable(
                interactionSource = remember{ MutableInteractionSource() },
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
