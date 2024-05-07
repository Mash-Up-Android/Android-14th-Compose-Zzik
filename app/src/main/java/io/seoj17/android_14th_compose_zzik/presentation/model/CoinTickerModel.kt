package io.seoj17.android_14th_compose_zzik.presentation.model

import io.seoj17.android_14th_compose_zzik.data.model.CoinInfo
import io.seoj17.android_14th_compose_zzik.data.model.CoinTicker

data class CoinTickerModel(
    val coinName: String,
    val marketCode: String,
    val currentPrice: Double,
    val changePrice: Double,
    val tradePrice24H: Double,
) {
    companion object {
        fun toCoinTickerModel(
            coinInfo: CoinInfo,
            coinTicker: CoinTicker,
        ): CoinTickerModel {
            return CoinTickerModel(
                coinName = coinInfo.name,
                marketCode = coinTicker.marketCode,
                currentPrice = coinTicker.currentPrice,
                changePrice = coinTicker.changePrice,
                tradePrice24H = coinTicker.tradePrice24H,
            )
        }
    }
}
