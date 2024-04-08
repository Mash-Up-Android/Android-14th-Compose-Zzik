package io.seoj17.android_14th_compose_zzik.navigation

import io.seoj17.android_14th_compose_zzik.R

enum class TopLevelDestination(
    val iconId: Int,
    val text: String,
    val route: String
) {
    HOME(
        iconId = R.drawable.ic_home,
        text = "거래소",
        route = "home"
    ),
    COIN_INFO(
        iconId = R.drawable.ic_coin_info,
        text = "코인정보",
        route = "coin_info"
    ),
    INVESTMENT_DETAILS(
        iconId = R.drawable.ic_investment_details,
        text = "투자내역",
        route = "investment_details"
    ),
    DEPOSIT_WITHDRAWAL(
        iconId = R.drawable.ic_deposit_withdrawal,
        text = "입출금",
        route = "deposit_withdrawal"
    ),
    MORE_DETAILS(
        iconId = R.drawable.ic_more_details,
        text = "더보기",
        route = "more_details"
    )
}
