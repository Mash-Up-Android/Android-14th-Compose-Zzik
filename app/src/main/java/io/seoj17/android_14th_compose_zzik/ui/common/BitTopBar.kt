package io.seoj17.android_14th_compose_zzik.ui.common

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import io.seoj17.android_14th_compose_zzik.R
import io.seoj17.android_14th_compose_zzik.ui.theme.BitWhiteColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BitTopBar(
    title: @Composable () -> Unit,
    needBackBtn: Boolean = true,
    onBackClicked: () -> Unit = {},
    menuAction: @Composable () -> Unit = {},
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        title = title,
        colors = TopAppBarDefaults.topAppBarColors(
            titleContentColor = BitWhiteColor,
            containerColor = Color.Transparent
        ),
        navigationIcon = {
            if (needBackBtn) {
                IconButton(onClick = onBackClicked) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back_btn),
                        contentDescription = "back button",
                        tint = BitWhiteColor
                    )
                }
            } else null
        },
        actions = { menuAction() }
    )
}
