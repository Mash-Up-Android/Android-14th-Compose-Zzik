package io.seoj17.android_14th_compose_zzik.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.seoj17.android_14th_compose_zzik.R
import io.seoj17.android_14th_compose_zzik.ui.component.UpBitButton
import io.seoj17.android_14th_compose_zzik.ui.component.UpBitRadioButton
import io.seoj17.android_14th_compose_zzik.ui.component.UpBitTopBar
import io.seoj17.android_14th_compose_zzik.ui.model.UpBitCoin
import io.seoj17.android_14th_compose_zzik.ui.model.UpBitOrderBook
import io.seoj17.android_14th_compose_zzik.ui.model.orderBookList
import io.seoj17.android_14th_compose_zzik.ui.theme.Android14thComposeZzikTheme
import io.seoj17.android_14th_compose_zzik.ui.theme.Blue
import io.seoj17.android_14th_compose_zzik.ui.theme.DarkGray
import io.seoj17.android_14th_compose_zzik.ui.theme.Gray
import io.seoj17.android_14th_compose_zzik.ui.theme.Navy
import io.seoj17.android_14th_compose_zzik.ui.theme.Red
import io.seoj17.android_14th_compose_zzik.ui.theme.Transparent
import io.seoj17.android_14th_compose_zzik.ui.theme.White
import io.seoj17.android_14th_compose_zzik.ui.utils.noRippleClickable
import kotlin.math.abs

@Composable
fun Detail(
    title: String,
    onBackPressed: () -> Unit = {},
) {
    val coin = UpBitCoin(
        market = "KRW",
        koreanName = "도지코인",
        englishName = "BTC/KRW",
        tradePrice = 945710.00f,
        accTradePrice = 692469f,
        signedChangePrice = 2365000f,
        signedChangeRate = 2.45f,
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        UpBitTopBar(
            title = title,
            showActionButton = true,
            actionIcon = R.drawable.ic_share,
            onBackButtonClick = { onBackPressed() },
            onActionButtonClick = { },
        )
        DetailHeader(
            coin = coin,
        )
        DetailTab()
        DetailContent(
            coin = coin,
        )
    }
}

@Composable
fun DetailHeader(
    modifier: Modifier = Modifier,
    coin: UpBitCoin,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        UpBitButton(
            iconId = R.drawable.ic_back,
            size = 20,
            onClick = {},
            description = "backButton",
        )
        DetailPrice(
            modifier = modifier.weight(1f),
            coin = coin,
        )
        UpBitButton(
            iconId = R.drawable.ic_forward,
            size = 20,
            onClick = {},
            description = "forwardButton",
        )
    }
}

@Composable
fun DetailPrice(
    modifier: Modifier = Modifier,
    coin: UpBitCoin,
) {
    val changeColor = if (coin.signedChangeRate > 0) Red else Blue
    val changeHead = if (coin.signedChangeRate > 0) "▲ " else "▼ "

    Column(
        modifier = modifier.padding(horizontal = 14.dp),
    ) {
        Text(
            fontSize = 22.sp,
            textAlign = TextAlign.Start,
            text = coin.tradePrice.toString(),
            color = changeColor,
        )
        Row(
            verticalAlignment = Alignment.Bottom,
        ) {
            Text(
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                text = coin.signedChangeRate.toString() + "%",
                color = changeColor,
            )
            Text(
                modifier = modifier.padding(horizontal = 8.dp),
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                text = changeHead + abs(coin.signedChangePrice).toString(),
                color = changeColor,
            )
        }
    }
}

@Composable
fun DetailTab(
    modifier: Modifier = Modifier,
) {
    var selected by rememberSaveable { mutableIntStateOf(0) }
    val onTabClick: (Int) -> Unit = { selected = it }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
    ) {
        DetailTabItem(
            modifier = modifier.weight(1f),
            text = "주문",
            index = 0,
            selected = selected,
            onTabClick = onTabClick,
        )
        DetailTabItem(
            modifier = modifier.weight(1f),
            text = "호가",
            index = 1,
            selected = selected,
            onTabClick = onTabClick,
        )
        DetailTabItem(
            modifier = modifier.weight(1f),
            text = "차트",
            index = 2,
            selected = selected,
            onTabClick = onTabClick,
        )
        DetailTabItem(
            modifier = modifier.weight(1f),
            text = "시세",
            index = 3,
            selected = selected,
            onTabClick = onTabClick,
        )
        DetailTabItem(
            modifier = modifier.weight(1f),
            text = "정보",
            index = 4,
            selected = selected,
            onTabClick = onTabClick,
        )
    }
}

@Composable
fun DetailTabItem(
    modifier: Modifier = Modifier,
    text: String,
    index: Int,
    selected: Int,
    onTabClick: (Int) -> Unit = {},
) {
    val isSelected = index == selected

    Box(
        modifier = modifier
            .background(Navy)
            .noRippleClickable { onTabClick(index) },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = modifier
                .padding(6.dp)
                .width(50.dp),
            textAlign = TextAlign.Center,
            text = text,
            color = if (isSelected) Gray else DarkGray,
        )
    }
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    coin: UpBitCoin,
) {
    var price by rememberSaveable { mutableFloatStateOf(coin.tradePrice) }
    val onPriceChange: (String) -> Unit = { price = it.toFloat() }

    Row(
        modifier = modifier
            .fillMaxSize(),
    ) {
        DetailOrderBook(
            modifier = modifier.weight(0.4f),
            orderBookList = orderBookList,
            onPriceChange = onPriceChange,
        )
        DetailTrade(
            modifier = modifier.weight(0.6f),
            price = price,
            onPriceChange = onPriceChange,
        )
    }
}

@Composable
fun DetailOrderBook(
    modifier: Modifier = Modifier,
    orderBookList: List<UpBitOrderBook>,
    onPriceChange: (String) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(orderBookList) { orderBook ->
            DetailOrderBookItem(
                orderBook = orderBook,
                onPriceChange = onPriceChange,
            )
        }
    }
}

@Composable
fun DetailOrderBookItem(
    modifier: Modifier = Modifier,
    orderBook: UpBitOrderBook,
    onPriceChange: (String) -> Unit = {},
) {
    Row(
        modifier = modifier.noRippleClickable {
            onPriceChange(orderBook.askPrice.toString())
        }
    ) {
        Text(
            modifier = modifier.padding(6.dp),
            textAlign = TextAlign.Center,
            text = orderBook.askPrice.toString(),
            color = Blue,
            maxLines = 1,
        )
        Text(
            modifier = modifier.padding(2.dp),
            textAlign = TextAlign.Center,
            text = orderBook.askSize.toString(),
            color = Gray,
            maxLines = 1,
        )
    }
}

@Composable
fun DetailTrade(
    modifier: Modifier = Modifier,
    price: Float,
    onPriceChange: (String) -> Unit = {},
) {
    Row(
        modifier = modifier
    ) {
        DetailTradeRadioTab()
        TextField(
            value = price.toString(),
            onValueChange = onPriceChange,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Transparent,
                unfocusedContainerColor = Transparent,
                disabledContainerColor = Transparent,
                focusedIndicatorColor = Transparent,
                unfocusedIndicatorColor = Transparent,
                disabledIndicatorColor = Transparent,
                focusedTextColor = White,
                unfocusedTextColor = White,
            ),
            singleLine = true,
        )
    }
}

@Composable
fun DetailTradeRadioTab(
    modifier: Modifier = Modifier,
) {
    var checked by rememberSaveable { mutableIntStateOf(0) }
    val onRadioClick: (Int) -> Unit = { checked = it }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        DetailTradeRadioItem(
            index = 0,
            checked = checked,
            text = "지정",
            onRadioClick = onRadioClick,
        )
        DetailTradeRadioItem(
            index = 1,
            checked = checked,
            text = "시장",
            onRadioClick = onRadioClick,
        )
        DetailTradeRadioItem(
            index = 2,
            checked = checked,
            text = "예약",
            onRadioClick = onRadioClick,
        )
    }
}

@Composable
fun DetailTradeRadioItem(
    modifier: Modifier = Modifier,
    index: Int,
    checked: Int,
    text: String,
    onRadioClick: (Int) -> Unit = {},
) {
    val isChecked = index == checked

    Row(
        modifier = modifier.padding(end = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        UpBitRadioButton(
            isChecked = isChecked,
            size = 24,
            description = "FirstRadioButton",
            index = index,
            onRadioClick = onRadioClick,
        )
        Text(
            modifier = modifier.padding(2.dp),
            textAlign = TextAlign.Center,
            text = text,
            fontSize = 14.sp,
            color = Gray,
            maxLines = 1,
        )
    }
}

@Composable
@Preview
fun DetailPreview() {
    Android14thComposeZzikTheme {
        Detail(title = "도지코인(DOGE/KRW)")
    }
}
