package io.seoj17.android_14th_compose_zzik.data.model

import io.seoj17.android_14th_compose_zzik.data.api.reseponse.MarketCoinInfoResponse

data class CoinInfo(
    val marketCode: String,
    val name: String,
)

fun MarketCoinInfoResponse.toMarketCode(): CoinInfo {
    return CoinInfo(
        marketCode = market,
        name = koreanName,
    )
}

fun List<MarketCoinInfoResponse>.toMarketCode(): List<CoinInfo> {
    return map {
        it.toMarketCode()
    }
}