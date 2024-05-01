package io.seoj17.android_14th_compose_zzik.ui.home.model

data class CoinInfoUiModel(
    val name: String,
    val code: String,
    val tradePrice: String,
    val changeRate: Double,
    val changePrice: Double,
    val accTradePrice: String,
) {
    fun changeRateToString(changeRate: Double) = "$changeRate%"
}
