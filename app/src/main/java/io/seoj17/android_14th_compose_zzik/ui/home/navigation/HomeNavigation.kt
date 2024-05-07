package io.seoj17.android_14th_compose_zzik.ui.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import io.seoj17.android_14th_compose_zzik.navigation.BitNavigationRoute
import io.seoj17.android_14th_compose_zzik.ui.home.DetailRoute
import io.seoj17.android_14th_compose_zzik.ui.home.HomeRoute

fun NavGraphBuilder.homeGraph(
    navController: NavController
) {
    navigation(
        route = BitNavigationRoute.HomeGraph.route,
        startDestination = BitNavigationRoute.HomeGraph.HomeRoute.route
    ) {
        composable(route = BitNavigationRoute.HomeGraph.HomeRoute.route) {
            HomeRoute(
                onCoinInfoClicked = { coinCode ->
                    navController.navigate(
                        route = BitNavigationRoute.HomeGraph.DetailRoute.route
                    )
                }
            )
        }
        composable(route = BitNavigationRoute.HomeGraph.DetailRoute.route) {
            DetailRoute(
                onBackClicked = navController::navigateUp
            )
        }
    }
}
