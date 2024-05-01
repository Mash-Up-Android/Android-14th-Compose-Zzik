package io.seoj17.android_14th_compose_zzik.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.seoj17.android_14th_compose_zzik.ui.home.model.CoinInfoUiModel
import io.seoj17.android_14th_compose_zzik.ui.theme.BitBlueColor
import io.seoj17.android_14th_compose_zzik.ui.theme.BitRedColor
import io.seoj17.android_14th_compose_zzik.ui.theme.BitWhiteColor

@Composable
fun CoinInfo(
    coinInfo: CoinInfoUiModel,
    onCoinInfoClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val textColor = if (coinInfo.changePrice < 0) {
        BitBlueColor
    } else {
        BitRedColor
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onCoinInfoClicked() },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CoinName(name = coinInfo.name, code = coinInfo.code)
        Text(text = coinInfo.tradePrice, color = textColor)
        Text(text = coinInfo.changePriceToString(coinInfo.changePrice), color = textColor)
        Text(text = coinInfo.accTradePrice)
    }
}

@Composable
private fun CoinName(
    name: String,
    code: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = name,
            color = BitWhiteColor
        )
        Text(
            text = code,
            fontSize = 12.sp,
            color = BitWhiteColor.copy(alpha = 0.5f)
        )
    }
}

@Composable
fun CoinInfoTitle(
    modifier: Modifier = Modifier
) {
    val titleList = listOf("한글명", "현재가", "전일대비", "거래대금")
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        titleList.forEach { text ->
            Text(
                text = text,
                fontSize = 12.sp,
                color = BitWhiteColor.copy(alpha = 0.5f)
            )
        }
    }
}
