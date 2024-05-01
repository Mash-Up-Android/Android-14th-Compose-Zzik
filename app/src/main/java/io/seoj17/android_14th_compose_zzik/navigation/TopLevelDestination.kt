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
        route = BitNavigationRoute.HomeGraph.route
    ),
    COIN_INFO(
        iconId = R.drawable.ic_coin_info,
        text = "코인정보",
        route = BitNavigationRoute.CoinInfoGraph.route
    ),
    INVESTMENT_DETAILS(
        iconId = R.drawable.ic_investment_details,
        text = "투자내역",
        route = BitNavigationRoute.InvestmentDetailsGraph.route
    ),
    DEPOSIT_WITHDRAWAL(
        iconId = R.drawable.ic_deposit_withdrawal,
        text = "입출금",
        route = BitNavigationRoute.DepositWithdrawalGraph.route
    ),
    MORE_DETAILS(
        iconId = R.drawable.ic_more_details,
        text = "더보기",
        route = BitNavigationRoute.MoreDetailsGraph.route
    )
}
