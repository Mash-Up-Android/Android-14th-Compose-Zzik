package io.seoj17.android_14th_compose_zzik.data.model

import io.seoj17.android_14th_compose_zzik.data.api.reseponse.TickerResponse

data class CoinTicker(
    val marketCode: String,
    val currentPrice: Double,
    val changePrice: Double,
    val tradePrice24H: Double,
)

fun TickerResponse.toCoinTicker(): CoinTicker {
    return CoinTicker(
        marketCode = code,
        currentPrice = tradePrice,
        changePrice = signedChangeRate,
        tradePrice24H = accTradePrice24h,
    )
}

fun List<TickerResponse>.toCoinTicker(): List<CoinTicker> {
    return map {
        it.toCoinTicker()
    }
}