package io.seoj17.android_14th_compose_zzik

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import io.seoj17.android_14th_compose_zzik.navigation.BitNavHost
import io.seoj17.android_14th_compose_zzik.navigation.TopLevelDestination
import io.seoj17.android_14th_compose_zzik.ui.common.BitBottomBar

@Composable
fun BitApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BitBottomBar(
                destinations = TopLevelDestination.entries,
                navController = navController
            )
        }
    ) { innerPadding ->
        BitNavHost(
            navController = navController,
            startDestination = TopLevelDestination.HOME.route,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
