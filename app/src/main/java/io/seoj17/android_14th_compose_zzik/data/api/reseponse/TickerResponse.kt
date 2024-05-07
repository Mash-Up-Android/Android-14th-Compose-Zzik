package io.seoj17.android_14th_compose_zzik.data.api.reseponse


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TickerResponse(
    @Json(name = "acc_ask_volume")
    val accAskVolume: Double,
    @Json(name = "acc_bid_volume")
    val accBidVolume: Double,
    @Json(name = "acc_trade_price")
    val accTradePrice: Double,
    @Json(name = "acc_trade_price_24h")
    val accTradePrice24h: Double,
    @Json(name = "acc_trade_volume")
    val accTradeVolume: Double,
    @Json(name = "acc_trade_volume_24h")
    val accTradeVolume24h: Double,
    @Json(name = "ask_bid")
    val askBid: String,
    @Json(name = "change")
    val change: String,
    @Json(name = "change_price")
    val changePrice: Double,
    @Json(name = "change_rate")
    val changeRate: Double,
    @Json(name = "code")
    val code: String,
    @Json(name = "delisting_date")
    val delistingDate: Any?,
    @Json(name = "high_price")
    val highPrice: Double,
    @Json(name = "highest_52_week_date")
    val highest52WeekDate: String,
    @Json(name = "highest_52_week_price")
    val highest52WeekPrice: Double,
    @Json(name = "is_trading_suspended")
    val isTradingSuspended: Boolean,
    @Json(name = "low_price")
    val lowPrice: Double,
    @Json(name = "lowest_52_week_date")
    val lowest52WeekDate: String,
    @Json(name = "lowest_52_week_price")
    val lowest52WeekPrice: Double,
    @Json(name = "market_state")
    val marketState: String,
    @Json(name = "market_warning")
    val marketWarning: String,
    @Json(name = "opening_price")
    val openingPrice: Double,
    @Json(name = "prev_closing_price")
    val prevClosingPrice: Double,
    @Json(name = "signed_change_price")
    val signedChangePrice: Double,
    @Json(name = "signed_change_rate")
    val signedChangeRate: Double,
    @Json(name = "stream_type")
    val streamType: String,
    @Json(name = "timestamp")
    val timestamp: Long,
    @Json(name = "trade_date")
    val tradeDate: String,
    @Json(name = "trade_price")
    val tradePrice: Double,
    @Json(name = "trade_time")
    val tradeTime: String,
    @Json(name = "trade_timestamp")
    val tradeTimestamp: Long,
    @Json(name = "trade_volume")
    val tradeVolume: Double,
    @Json(name = "type")
    val type: String,
)