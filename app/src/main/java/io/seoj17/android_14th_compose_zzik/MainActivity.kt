package io.seoj17.android_14th_compose_zzik

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import io.seoj17.android_14th_compose_zzik.ui.theme.Android14thComposeZzikTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android14thComposeZzikTheme {
                BitApp()
            }
        }
    }
}
