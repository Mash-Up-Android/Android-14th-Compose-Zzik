package io.seoj17.android_14th_compose_zzik.ui.home.exchange

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import io.seoj17.android_14th_compose_zzik.ui.theme.Red
import io.seoj17.android_14th_compose_zzik.ui.utils.noRippleClickable

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
        ExchangeCoinSortTab()
        ExchangeCoinList(
            coinList = coinList[selected],
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
            .noRippleClickable { onBoxClick(index) },
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
fun ExchangeCoinSortTab(
    modifier: Modifier = Modifier,
) {

}

@Composable
fun ExchangeCoinList(
    modifier: Modifier = Modifier,
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
            .height(40.dp)
            .fillMaxWidth()
            .noRippleClickable { onClick() },
    ) {
        val changeColor = if (coin.signedChangeRate > 0) Red else Blue

        Spacer(
            modifier = modifier.weight(0.1f),
        )
        CoinItemSector(
            modifier = modifier.weight(0.3f),
            mainText = coin.koreanName,
            subText = coin.englishName,
            mainColor = Gray,
            subColor = DarkGray,
            alignment = Alignment.Start,
        )
        CoinItemSector(
            modifier = modifier.weight(0.3f),
            mainText = coin.tradePrice.toString(),
            mainColor = changeColor,
            subColor = DarkGray,
            isSubTextVisible = false,
            alignment = Alignment.End,
        )
        CoinItemSector(
            modifier = modifier.weight(0.2f),
            mainText = coin.signedChangeRate.toString() + "%",
            subText = coin.accTradePrice.toString(),
            mainColor = changeColor,
            subColor = changeColor,
            alignment = Alignment.End,
        )
        CoinItemSector(
            modifier = modifier.weight(0.3f),
            mainText = coin.accTradePrice.toString() + "백만",
            mainColor = Gray,
            subColor = DarkGray,
            alignment = Alignment.End,
        )
    }
}

@Composable
fun CoinItemSector(
    modifier: Modifier = Modifier,
    mainText: String,
    subText: String = "",
    mainColor: Color,
    subColor: Color = Gray,
    isSubTextVisible: Boolean = true,
    alignment: Alignment.Horizontal = Alignment.Start,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = alignment,
    ) {
        Text(
            modifier = modifier,
            text = mainText,
            maxLines = 1,
            fontSize = 14.sp,
            color = mainColor,
        )
        if (isSubTextVisible) {
            Text(
                modifier = modifier,
                text = subText,
                maxLines = 1,
                fontSize = 10.sp,
                color = subColor,
            )
        }
    }
}

@Composable
@Preview
private fun ExchangePreview() {
    Android14thComposeZzikTheme {
        Exchange()
    }
}
