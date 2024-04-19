package io.seoj17.android_14th_compose_zzik.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.seoj17.android_14th_compose_zzik.R
import io.seoj17.android_14th_compose_zzik.ui.component.UpBitTopBar
import io.seoj17.android_14th_compose_zzik.ui.model.UpBitCoin
import io.seoj17.android_14th_compose_zzik.ui.theme.Android14thComposeZzikTheme
import io.seoj17.android_14th_compose_zzik.ui.theme.Blue
import io.seoj17.android_14th_compose_zzik.ui.theme.DarkGray
import io.seoj17.android_14th_compose_zzik.ui.theme.Red
import kotlin.math.abs

@Composable
fun Detail(
    title: String,
    onBackPressed: () -> Unit,
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
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = modifier.size(20.dp),
            onClick = { },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "backButton",
                tint = DarkGray,
            )
        }
        DetailPrice(
            modifier = modifier.weight(1f),
            coin = coin,
        )
        IconButton(
            modifier = modifier.size(20.dp),
            onClick = { },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_forward),
                contentDescription = "forwardButton",
                tint = DarkGray,
            )
        }
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
@Preview
fun DetailPreview() {
    Android14thComposeZzikTheme {
        Detail(
            title = "도지코인(DOGE/KRW)",
            onBackPressed = { },
        )
    }
}
