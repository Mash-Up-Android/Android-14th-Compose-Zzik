package io.seoj17.android_14th_compose_zzik.navigation

sealed class BitNavigationRoute(val route: String) {
    object HomeGraph : BitNavigationRoute("home_graph") {
        object HomeRoute : BitNavigationRoute("home_graph/main")
        object DetailRoute : BitNavigationRoute("home_graph/detail")
    }
    object CoinInfoGraph : BitNavigationRoute("coinInfo_graph") {
        object CoinInfoRoute : BitNavigationRoute("coinInfo_graph/main")
    }
    object InvestmentDetailsGraph : BitNavigationRoute("investmentDetails_graph") {
        object InvestmentDetailsRoute : BitNavigationRoute("investmentDetails_graph/main")
    }
    object DepositWithdrawalGraph : BitNavigationRoute("depositWithdrawal_graph") {
        object DepositWithdrawalRoute : BitNavigationRoute("depositWithdrawal_graph/main")
    }
    object MoreDetailsGraph : BitNavigationRoute("moreDetails_graph") {
        object MoreDetailsRoute : BitNavigationRoute("moreDetails_graph/main")
    }
}
