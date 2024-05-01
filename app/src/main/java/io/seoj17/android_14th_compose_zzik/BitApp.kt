package io.seoj17.android_14th_compose_zzik

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.seoj17.android_14th_compose_zzik.navigation.BitNavHost
import io.seoj17.android_14th_compose_zzik.navigation.BitNavigationRoute
import io.seoj17.android_14th_compose_zzik.navigation.TopLevelDestination
import io.seoj17.android_14th_compose_zzik.ui.common.BitBottomBar
import io.seoj17.android_14th_compose_zzik.ui.theme.BitBackgroundColor
import io.seoj17.android_14th_compose_zzik.ui.theme.BitWhiteColor

@Composable
fun BitApp() {
    val navController = rememberNavController()
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    showBottomBar = when (navController.currentBackStackEntryAsState().value?.destination?.route) {
        BitNavigationRoute.HomeGraph.DetailRoute.route -> false
        else -> true
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BitBottomBar(
                    destinations = TopLevelDestination.entries,
                    navController = navController
                )
            }
        },
        containerColor = BitBackgroundColor,
        contentColor = BitWhiteColor
    ) { innerPadding ->
        BitNavHost(
            navController = navController,
            startDestination = TopLevelDestination.HOME.route,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
