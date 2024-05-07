package io.seoj17.android_14th_compose_zzik.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.seoj17.android_14th_compose_zzik.presentation.model.CoinTickerModel
import io.seoj17.android_14th_compose_zzik.presentation.ui.home.model.CoinHomeUiState
import io.seoj17.android_14th_compose_zzik.presentation.ui.theme.CoinMainColor
import io.seoj17.android_14th_compose_zzik.presentation.ui.theme.CoinPriceDownColor
import io.seoj17.android_14th_compose_zzik.presentation.ui.theme.CoinPriceUpColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoinHomeScreen(
    onDetailClick: () -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by homeViewModel.coinHomeUiState.collectAsStateWithLifecycle()

    if (uiState.marketList.list.isNotEmpty()) {
        homeViewModel.startCoinRealTime()
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        //homeViewModel.getAllMarketCode()
        val pageList = listOf("KRW", "BTC", "USDT", "관심")
        val pageState = rememberPagerState { pageList.size }

        CoinSearchBar(modifier = Modifier.fillMaxWidth())
        CoinCategory(
            modifier = Modifier,
            state = pageState,
            pageList = pageList,
        )
        CoinListPager(
            pageState = pageState,
            state = uiState,
            onDetailClick = onDetailClick,
        )
    }
}

@Composable
private fun CoinSearchBar(
    modifier: Modifier,
) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = modifier.padding(
            top = 16.dp,
        )
    ) {
        BasicTextField(
            modifier = Modifier.padding(horizontal = 16.dp),
            value = text,
            onValueChange = {
                text = it
            },
            singleLine = true,
            decorationBox = { innerTextField ->
                Column(modifier = Modifier) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = CoinMainColor,
                        )
                        innerTextField()
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp),
            color = Color(0xFF07275D)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CoinCategory(
    modifier: Modifier,
    state: PagerState,
    pageList: List<String>,
) {
    val coroutineScope = rememberCoroutineScope()
    Row(
        modifier = modifier.padding(
            vertical = 8.dp,
            horizontal = 12.dp,
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        pageList.forEachIndexed { idx, item ->
            Box(
                modifier = Modifier.border(
                    width = 1.dp,
                    color = if (idx == state.currentPage) {
                        CoinMainColor
                    } else {
                        Color.LightGray
                    },
                )
            ) {
                Text(
                    modifier = Modifier
                        .padding(
                            vertical = 5.dp,
                            horizontal = 12.dp,
                        )
                        .clickable(
                            role = Role.Button,
                            onClick = {
                                coroutineScope.launch { state.scrollToPage(idx) }
                            },
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                        ),
                    text = item,
                    color = if (idx == state.currentPage) {
                        CoinMainColor
                    } else {
                        Color.Gray
                    },
                )
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoinListPager(
    modifier: Modifier = Modifier,
    pageState: PagerState,
    onDetailClick: () -> Unit,
    state: CoinHomeUiState,
) {
    HorizontalPager(
        modifier = modifier.fillMaxWidth(),
        state = pageState,
        pageContent = { page ->
            CoinList(
                modifier = Modifier,
                onDetailClick = onDetailClick,
                state = state,
            )
        },
    )
}

@Composable
private fun CoinList(
    modifier: Modifier,
    onDetailClick: () -> Unit,
    state: CoinHomeUiState,
) {
    val coinListState = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = coinListState,
    ) {
        item {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp),
                color = Color(0xFFD8CFCF)
            )
            CoinHeader(modifier = Modifier)
        }

        items(
            count = state.coinTickerList.list.size,
            itemContent = {
                CoinItem(
                    modifier = Modifier.fillMaxWidth(),
                    onDetailClick = onDetailClick,
                    item = state.coinTickerList.list[it],
                )
                if (it != 9) {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(1.dp),
                        color = Color(0xFFEFEFEF)
                    )
                }
            }
        )
    }
}

@Composable
private fun CoinHeader(modifier: Modifier) {
    Row(
        modifier = modifier.padding(
            vertical = 8.dp,
            horizontal = 16.dp,
        ),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier.weight(2f),
            text = "한글명",
            fontSize = 11.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
        )
        Text(
            modifier = Modifier.weight(1.1f),
            text = "현재가",
            fontSize = 11.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
        )
        Text(
            modifier = Modifier.weight(1f),
            text = "전일대비",
            fontSize = 11.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
        )
        Text(
            modifier = Modifier.weight(0.8f),
            text = "거래대금",
            fontSize = 11.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
        )
    }

    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .width(1.dp),
        color = Color(0xFFEFEFEF)
    )
}

@Composable
private fun CoinItem(
    modifier: Modifier,
    onDetailClick: () -> Unit,
    item: CoinTickerModel,
) {
    val changePriceRate = (item.changePrice * 100.0)

    Column(
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clickable(
                    role = Role.Button,
                    onClick = onDetailClick,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                modifier = Modifier.weight(0.5f),
                text = item.coinName,
            )
            Text(
                modifier = Modifier.weight(0.5f),
                text = String
                    .format("%,.2f", item.currentPrice)
                    .trimEnd { it == '0' }
                    .trimEnd { it == '.' },
                color = if (changePriceRate > 0) {
                    CoinPriceUpColor
                } else {
                    CoinPriceDownColor
                },
            )
            Text(
                modifier = Modifier.padding(end = 12.dp),
                text = "${String.format("%.2f", changePriceRate)}%",
                color = if (changePriceRate > 0) {
                    CoinPriceUpColor
                } else {
                    CoinPriceDownColor
                },
            )
            Text(
                text = "${String.format("%,d", (item.tradePrice24H / 1_000_000).toInt())}백만",
            )
        }
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = item
                .marketCode
                .split("-")
                .reversed()
                .joinToString("/"),
            fontSize = 13.sp,
            color = Color.Gray,
        )
    }
}