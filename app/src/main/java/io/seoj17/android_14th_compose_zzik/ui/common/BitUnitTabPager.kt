package io.seoj17.android_14th_compose_zzik.ui.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.seoj17.android_14th_compose_zzik.ui.home.model.CoinInfoUiModel
import io.seoj17.android_14th_compose_zzik.ui.theme.BitBlueColor
import io.seoj17.android_14th_compose_zzik.ui.theme.BitWhiteColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BitUnitTabPager(
    onCoinInfoClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val tabData = listOf("KRW", "BTC", "USDT")
    val pagerState = rememberPagerState { tabData.size }
    val coroutineScope = rememberCoroutineScope()

    Row(modifier = modifier) {
        tabData.forEachIndexed { idx, text ->
            BitUnit(
                text = text,
                color = if (pagerState.currentPage == idx) {
                    BitBlueColor
                } else {
                    BitWhiteColor.copy(alpha = 0.5f)
                },
                onClick = {
                    coroutineScope.launch {
                        pagerState.scrollToPage(idx)
                    }
                }
            )
        }
    }
    Divider(modifier = Modifier.padding(top = 8.dp), color = BitWhiteColor.copy(alpha = 0.5f))

    val coinInfo = CoinInfoUiModel(name = "비트코인", code = "BTC/KRW", tradePrice = "90,000,000", changePrice = -10.0, accTradePrice = "700,000백만")
    val coinInfoList = List(10) { _ -> coinInfo }

    HorizontalPager(state = pagerState) { _ ->
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(
                count = coinInfoList.size + 1
            ) {idx ->
                when (idx) {
                    0 -> CoinInfoTitle()
                    else -> CoinInfo(
                        coinInfo = coinInfoList[idx - 1],
                        onCoinInfoClicked = {
                            onCoinInfoClicked(coinInfoList[idx - 1].code)
                        }
                    )
                }
                Divider(color = BitWhiteColor.copy(alpha = 0.2f))
            }
        }
    }
}

@Composable
private fun BitUnit(
    text: String,
    color: Color,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .border(1.dp, color)
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
