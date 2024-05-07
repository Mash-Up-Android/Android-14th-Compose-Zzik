package io.seoj17.android_14th_compose_zzik.presentation.model

import io.seoj17.android_14th_compose_zzik.R

sealed class CoinScreen(
    val route: String,
    val label: String,
    val iconResourceId: Int = 0,
) {
    data object Home : CoinScreen(
        route = "home",
        label = "거래소",
        iconResourceId = R.drawable.ic_home,
    )
    
    data object Detail : CoinScreen(
        route = "detail",
        label = "코인 상세",
    )
    
    data object CoinInfo : CoinScreen(
        route = "setting",
        label = "코인 정보",
        iconResourceId = R.drawable.ic_coin_info,
    )
    
    data object CoinInvestmentList : CoinScreen(
        route = "investment_list",
        label = "투자 내역",
        iconResourceId = R.drawable.ic_investment_list,
    )
    
    data object DepositWithdrawal : CoinScreen(
        route = "deposit_withdrawal",
        label = "입출금",
        iconResourceId = R.drawable.ic_deposit_withdrawal,
    )
    
    data object MyPage : CoinScreen(
        route = "my_page",
        label = "더보기",
        iconResourceId = R.drawable.ic_my_page,
    )
}
