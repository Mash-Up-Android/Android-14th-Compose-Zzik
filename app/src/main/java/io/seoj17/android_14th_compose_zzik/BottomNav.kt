package io.seoj17.android_14th_compose_zzik

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import io.seoj17.android_14th_compose_zzik.ui.detail.Detail
import io.seoj17.android_14th_compose_zzik.ui.home.account.Account
import io.seoj17.android_14th_compose_zzik.ui.home.exchange.Exchange
import io.seoj17.android_14th_compose_zzik.ui.home.history.History
import io.seoj17.android_14th_compose_zzik.ui.home.info.Info
import io.seoj17.android_14th_compose_zzik.ui.home.more.More
import io.seoj17.android_14th_compose_zzik.ui.theme.BottomNav
import io.seoj17.android_14th_compose_zzik.ui.theme.DarkGray
import io.seoj17.android_14th_compose_zzik.ui.theme.White
import io.seoj17.android_14th_compose_zzik.ui.utils.noRippleClickable

@Composable
fun BottomNav(
    navController: NavHostController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(BottomNav),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavTab(
            Modifier.weight(1f),
            BottomNavItem.Exchange,
            currentRoute,
            navController,
        )

        BottomNavTab(
            Modifier.weight(1f),
            BottomNavItem.Info,
            currentRoute,
            navController,
        )

        BottomNavTab(
            Modifier.weight(1f),
            BottomNavItem.History,
            currentRoute,
            navController,
        )

        BottomNavTab(
            Modifier.weight(1f),
            BottomNavItem.Account,
            currentRoute,
            navController,
        )

        BottomNavTab(
            Modifier.weight(1f),
            BottomNavItem.More,
            currentRoute,
            navController,
        )
    }
}

@Composable
private fun BottomNavTab(
    modifier: Modifier = Modifier,
    item: BottomNavItem,
    currentRoute: String?,
    navController: NavHostController,
) {
    val selectedColor = if (currentRoute == item.route) White else DarkGray

    val onClick = {
        navController.navigate(item.route) {
            navController.graph.startDestinationRoute?.let {
                popUpTo(it) { saveState = true }
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    Column(
        modifier = modifier
            .noRippleClickable { onClick() }
            .padding(vertical = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = stringResource(id = item.title),
            modifier = Modifier.size(20.dp),
            tint = selectedColor,
        )

        Text(
            text = stringResource(id = item.title),
            color = selectedColor,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 4.dp),
        )
    }
}

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Exchange.route
    ) {
        composable(BottomNavItem.Exchange.route) {
            Exchange(
                onDetailClick = { title ->
                    navController.navigate("detail/$title")
                }
            )
        }
        composable(BottomNavItem.Info.route) {
            Info()
        }
        composable(BottomNavItem.History.route) {
            History()
        }
        composable(BottomNavItem.Account.route) {
            Account()
        }
        composable(BottomNavItem.More.route) {
            More()
        }
        composable(
            route = "detail/{title}",
            arguments = listOf(navArgument("title") { type = NavType.StringType })
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""

            Detail(
                title = title,
                onBackPressed = { navController.navigateUp() }
            )
        }
    }
}

sealed class BottomNavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String,
) {
    data object Exchange : BottomNavItem(R.string.exchange, R.drawable.ic_exchange, "home/exchange")
    data object Info : BottomNavItem(R.string.info, R.drawable.ic_info, "home/info")
    data object History : BottomNavItem(R.string.history, R.drawable.ic_history, "home/history")
    data object Account : BottomNavItem(R.string.account, R.drawable.ic_account, "home/account")
    data object More : BottomNavItem(R.string.more, R.drawable.ic_more, "home/more")
}
