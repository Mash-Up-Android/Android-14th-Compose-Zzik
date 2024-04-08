package io.seoj17.android_14th_compose_zzik.ui.bottom

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import io.seoj17.android_14th_compose_zzik.model.CoinScreen

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    val navItem = listOf(
        CoinScreen.Home,
        CoinScreen.CoinInfo,
        CoinScreen.CoinInvestmentList,
        CoinScreen.DepositWithdrawal,
        CoinScreen.MyPage,
    )
    
    NavigationBar {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        
        navItem.forEach { screen ->
            NavigationBarItem(
                label = {
                    Text(text = screen.label)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.iconResourceId),
                        contentDescription = null,
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navHostController.navigate(screen.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = Color.Gray,
                    selectedTextColor = Color.White,
                ),
            )
        }
    }
}