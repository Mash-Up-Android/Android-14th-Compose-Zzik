package io.seoj17.android_14th_compose_zzik.data.api.reseponse


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.seoj17.android_14th_compose_zzik.data.model.CoinInfo

@JsonClass(generateAdapter = true)
data class MarketCoinInfoResponse(
    @Json(name = "english_name")
    val englishName: String,
    @Json(name = "korean_name")
    val koreanName: String,
    @Json(name = "market")
    val market: String,
    @Json(name = "market_event")
    val marketEvent: MarketEvent,
    @Json(name = "market_warning")
    val marketWarning: String,
)
