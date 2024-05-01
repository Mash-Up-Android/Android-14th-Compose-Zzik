package io.seoj17.android_14th_compose_zzik.ui.home.model

data class CoinInfoUiModel(
    val name: String,
    val code: String,
    val tradePrice: String,
    val changePrice: Double,
    val accTradePrice: String,
) {
    fun changePriceToString(changePrice: Double) = "$changePrice%"
}
