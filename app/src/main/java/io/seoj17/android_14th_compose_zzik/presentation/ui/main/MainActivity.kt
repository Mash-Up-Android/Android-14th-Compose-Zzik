package io.seoj17.android_14th_compose_zzik.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.seoj17.android_14th_compose_zzik.presentation.model.CoinScreen
import io.seoj17.android_14th_compose_zzik.presentation.navigation.CoinNavHost
import io.seoj17.android_14th_compose_zzik.presentation.ui.bottom.BottomNavigation
import io.seoj17.android_14th_compose_zzik.presentation.ui.theme.NoRippleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                        BottomNavigation(navHostController = navController)
                    }
                }
            ) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    CoinNavHost(
                        startDestination = CoinScreen.Home,
                        navHostController = navController,
                    )
                }
            }
        }
    }
}