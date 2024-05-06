package io.seoj17.android_14th_compose_zzik.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.seoj17.android_14th_compose_zzik.ui.common.BitDetailTab
import io.seoj17.android_14th_compose_zzik.ui.common.BitTopBar
import io.seoj17.android_14th_compose_zzik.ui.home.model.CoinInfoUiModel
import io.seoj17.android_14th_compose_zzik.ui.theme.BitBackgroundColor
import io.seoj17.android_14th_compose_zzik.ui.theme.BitBlueColor
import io.seoj17.android_14th_compose_zzik.ui.theme.BitRedColor
import io.seoj17.android_14th_compose_zzik.ui.theme.BitWhiteColor

@Composable
fun DetailRoute(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit
) {
    DetailScreen(modifier = modifier, onBackClicked = onBackClicked)
}

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit
) {
    val coinInfo = CoinInfoUiModel(name = "비트코인", code = "BTC/KRW", tradePrice = "90,000,000", changeRate = -10.0, changePrice = -1000.5, accTradePrice = "700,000백만")
    Scaffold(
        modifier = modifier,
        topBar = {
            BitTopBar(
                title = {
                    Text(text = "비트코인", color = BitWhiteColor)
                },
                onBackClicked = onBackClicked
            )
        },
        containerColor = BitBackgroundColor
    ) { innerPadding ->
        DetailContent(
            modifier = Modifier.padding(innerPadding),
            coinInfoUiModel = coinInfo
        )
    }
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    coinInfoUiModel: CoinInfoUiModel
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        DetailCoinPrice(coinInfoUiModel = coinInfoUiModel)
        BitDetailTab()
    }
}

@Composable
private fun DetailCoinPrice(
    modifier: Modifier = Modifier,
    coinInfoUiModel: CoinInfoUiModel
) {
    val textColor = if (coinInfoUiModel.changeRate < 0) {
        BitBlueColor
    } else {
        BitRedColor
    }
    Column(
        modifier = modifier.padding(horizontal = 24.dp)
    ) {
        Text(
            text = coinInfoUiModel.tradePrice,
            fontSize = 24.sp,
            color = textColor
        )
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = coinInfoUiModel.changeRateToString(coinInfoUiModel.changeRate), color = textColor)
            Text(text = coinInfoUiModel.changePrice.toString(), color = textColor)
        }
    }
}
