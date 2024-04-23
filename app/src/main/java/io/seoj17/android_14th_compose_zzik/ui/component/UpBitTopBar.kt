package io.seoj17.android_14th_compose_zzik.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.seoj17.android_14th_compose_zzik.R.drawable
import io.seoj17.android_14th_compose_zzik.ui.theme.Android14thComposeZzikTheme
import io.seoj17.android_14th_compose_zzik.ui.theme.Gray

private val AppBarHeight = 56.dp
private val IconSizeModifier = Modifier.size(40.dp)

@Composable
fun UpBitTopBar(
    modifier: Modifier = Modifier,
    title: String,
    showActionButton: Boolean = false,
    @DrawableRes actionIcon: Int = drawable.ic_share,
    onBackButtonClick: () -> Unit,
    onActionButtonClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(AppBarHeight),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        IconButton(
            onClick = onBackButtonClick,
            modifier = IconSizeModifier,
        ) {
            Icon(
                painter = painterResource(id = drawable.ic_back),
                contentDescription = "BackButton",
                tint = Gray,
            )
        }

        Text(
            modifier = Modifier.weight(1f),
            text = title,
            color = Gray,
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )
        if (showActionButton) {
            IconButton(onClick = onActionButtonClick, modifier = IconSizeModifier) {
                Icon(
                    painter = painterResource(id = actionIcon),
                    contentDescription = "actionButton",
                    tint = Gray
                )
            }
        } else {
            Spacer(IconSizeModifier)
        }
    }
}

@Composable
@Preview
private fun UpBitTopBarPreview() {
    Android14thComposeZzikTheme {
        UpBitTopBar(
            title = "비트코인",
            onBackButtonClick = { }
        )
    }
}

