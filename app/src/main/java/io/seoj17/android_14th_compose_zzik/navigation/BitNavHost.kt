package io.seoj17.android_14th_compose_zzik.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.seoj17.android_14th_compose_zzik.ui.excepthome.compose.CoinInfoRoute
import io.seoj17.android_14th_compose_zzik.ui.excepthome.compose.DepositWithdrawalRoute
import io.seoj17.android_14th_compose_zzik.ui.excepthome.compose.InvestmentDetailsRoute
import io.seoj17.android_14th_compose_zzik.ui.excepthome.compose.MoreDetailsRoute
import io.seoj17.android_14th_compose_zzik.ui.home.navigation.homeGraph

@Composable
fun BitNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeGraph(navController = navController)
        composable(route = TopLevelDestination.COIN_INFO.route) {
            CoinInfoRoute()
        }
        composable(route = TopLevelDestination.INVESTMENT_DETAILS.route) {
            InvestmentDetailsRoute()
        }
        composable(route = TopLevelDestination.DEPOSIT_WITHDRAWAL.route) {
            DepositWithdrawalRoute()
        }
        composable(route = TopLevelDestination.MORE_DETAILS.route) {
            MoreDetailsRoute()
        }
    }
}
