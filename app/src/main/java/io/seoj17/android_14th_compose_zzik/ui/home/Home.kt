package io.seoj17.android_14th_compose_zzik.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.seoj17.android_14th_compose_zzik.BottomNav
import io.seoj17.android_14th_compose_zzik.BottomNavGraph
import io.seoj17.android_14th_compose_zzik.ui.theme.Background

@Composable
fun Home() {
    val navController = rememberNavController()

    Scaffold(
        containerColor = Background,
        bottomBar = {
            if (navController.currentBackStackEntryAsState().value?.destination?.route?.startsWith("home") == true) {
                BottomNav(navController = navController)
            }
        }
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {
            BottomNavGraph(navController = navController)
        }
    }
}

@Preview
@Composable
private fun MainPreview() {
    Home()
}
