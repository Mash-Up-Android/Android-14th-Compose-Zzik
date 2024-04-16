package io.seoj17.android_14th_compose_zzik.ui.home.exchange

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.seoj17.android_14th_compose_zzik.R
import io.seoj17.android_14th_compose_zzik.ui.component.UpBitHeader
import io.seoj17.android_14th_compose_zzik.ui.component.UpBitSearchBar
import io.seoj17.android_14th_compose_zzik.ui.model.UpBitCoin
import io.seoj17.android_14th_compose_zzik.ui.model.coinList
import io.seoj17.android_14th_compose_zzik.ui.theme.Android14thComposeZzikTheme
import io.seoj17.android_14th_compose_zzik.ui.theme.Blue
import io.seoj17.android_14th_compose_zzik.ui.theme.DarkGray
import io.seoj17.android_14th_compose_zzik.ui.theme.Gray

@Composable
fun Exchange() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        var selected by rememberSaveable { mutableIntStateOf(0) }

        UpBitHeader(title = stringResource(R.string.exchange))
        UpBitSearchBar(hint = stringResource(id = R.string.exchange_search_hint))
        ExchangeCoinCategory(
            selected = selected,
            onBoxClick = {
                selected = it
            },
        )
        ExchangeCoinList(
            selected = selected,
            coinList = coinList,
        )
    }
}

@Composable
fun ExchangeCoinCategory(
    modifier: Modifier = Modifier,
    selected: Int,
    onBoxClick: (Int) -> Unit = {},
) {
    Row(
        modifier = modifier.padding(
            top = 10.dp,
            bottom = 10.dp,
            start = 14.dp
        ),
    ) {
        ExchangeCoinTextBox(
            text = stringResource(id = R.string.krw),
            index = 0,
            selected = selected,
            onBoxClick = onBoxClick,
        )
        ExchangeCoinTextBox(
            text = stringResource(id = R.string.btc),
            index = 1,
            selected = selected,
            onBoxClick = onBoxClick,
        )
        ExchangeCoinTextBox(
            text = stringResource(id = R.string.usdt),
            index = 2,
            selected = selected,
            onBoxClick = onBoxClick,
        )
    }
}

@Composable
fun ExchangeCoinTextBox(
    modifier: Modifier = Modifier,
    text: String,
    index: Int,
    selected: Int,
    onBoxClick: (Int) -> Unit = {},
) {
    val isSelected = index == selected

    Box(
        modifier = modifier
            .border(
                width = 2.dp,
                color = if (isSelected) Blue else DarkGray,
            )
            .clickable { onBoxClick(index) },
    ) {
        Text(
            modifier = modifier
                .padding(6.dp)
                .width(50.dp),
            textAlign = TextAlign.Center,
            text = text,
            color = if (isSelected) Blue else DarkGray,
        )
    }
}

@Composable
fun ExchangeCoinList(
    modifier: Modifier = Modifier,
    selected: Int,
    coinList: List<UpBitCoin>,
    onClick: () -> Unit = {},
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        items(coinList) { coin ->
            CoinItem(
                coin = coin,
                onClick = onClick
            )
            Divider(
                modifier = modifier
                    .fillMaxWidth()
                    .height(1.dp),
                color = DarkGray,
            )
        }
    }
}

@Composable
fun CoinItem(
    modifier: Modifier = Modifier,
    coin: UpBitCoin,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .padding(
                horizontal = 10.dp,
                vertical = 5.dp,
            )
            .fillMaxWidth()
            .clickable { onClick() },
    ) {
        Column(
            modifier = modifier.weight(0.2f),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = modifier,
                textAlign = TextAlign.Center,
                text = coin.koreanName,
                fontSize = 14.sp,
                color = Gray,
            )
            Text(
                modifier = modifier,
                textAlign = TextAlign.Center,
                text = coin.englishName,
                fontSize = 10.sp,
                color = DarkGray,
            )
        }
        Text(
            modifier = modifier.weight(0.3f),
            textAlign = TextAlign.Center,
            text = coin.tradePrice.toString(),
            fontSize = 14.sp,
            color = Blue,
        )
        Column(
            modifier = modifier.weight(0.2f),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = modifier,
                textAlign = TextAlign.Center,
                text = coin.signedChangeRate.toString() + "%",
                fontSize = 12.sp,
                color = Blue,
            )
            Text(
                modifier = modifier,
                textAlign = TextAlign.Center,
                text = coin.signedChangePrice.toString(),
                fontSize = 12.sp,
                color = Blue,
            )
        }
        Text(
            modifier = modifier.weight(0.3f),
            textAlign = TextAlign.Center,
            text = coin.accTradePrice.toString() + "백만",
            fontSize = 12.sp,
            color = Gray,
        )
    }
}

@Composable
@Preview
private fun ExchangePreview() {
    Android14thComposeZzikTheme {
        Exchange()
    }
}
