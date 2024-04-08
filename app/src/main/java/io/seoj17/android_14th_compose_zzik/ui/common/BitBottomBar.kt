package io.seoj17.android_14th_compose_zzik.ui.common

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import io.seoj17.android_14th_compose_zzik.navigation.TopLevelDestination

@Composable
fun BitBottomBar(
    destinations: List<TopLevelDestination>,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar {
        destinations.forEach { destination ->
            NavigationBarItem(
                selected = destination.route == backStackEntry.value?.destination?.route,
                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = destination.iconId),
                        contentDescription = destination.text
                    )
                }
            )
        }
    }
}
