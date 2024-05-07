package io.seoj17.android_14th_compose_zzik.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.seoj17.android_14th_compose_zzik.presentation.model.CoinScreen
import io.seoj17.android_14th_compose_zzik.presentation.ui.coininfo.CoinInfoScreen
import io.seoj17.android_14th_compose_zzik.presentation.ui.deposit.CoinDepositWithdrawal
import io.seoj17.android_14th_compose_zzik.presentation.ui.detail.CoinDetailScreen
import io.seoj17.android_14th_compose_zzik.presentation.ui.home.CoinHomeScreen
import io.seoj17.android_14th_compose_zzik.presentation.ui.investment.CoinInvestmentListScreen
import io.seoj17.android_14th_compose_zzik.presentation.ui.mypage.MyPageScreen

@Composable
fun CoinNavHost(
    modifier: Modifier = Modifier,
    startDestination: CoinScreen,
    navHostController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination.route,
    ) {
        composable(route = CoinScreen.Home.route) {
            CoinHomeScreen(
                onDetailClick = {
                    navHostController.navigate(CoinScreen.Detail.route)
                }
            )
        }
        
        composable(route = CoinScreen.Detail.route) {
            CoinDetailScreen(
                onBackClick = {
                    navHostController.popBackStack()
                }
            )
        }
        
        composable(route = CoinScreen.CoinInfo.route) {
            CoinInfoScreen()
        }
        
        composable(route = CoinScreen.CoinInvestmentList.route) {
            CoinInvestmentListScreen()
        }
        
        composable(route = CoinScreen.DepositWithdrawal.route) {
            CoinDepositWithdrawal()
        }
        
        composable(route = CoinScreen.MyPage.route) {
            MyPageScreen()
        }
    }
}