package io.seoj17.android_14th_compose_zzik.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.seoj17.android_14th_compose_zzik.ui.theme.DarkGray

@Composable
fun UpBitButton(
    modifier: Modifier = Modifier,
    iconId: Int,
    size : Int,
    description: String,
    onClick: () -> Unit = { },
) {
    IconButton(
        modifier = modifier.size(size.dp),
        onClick = onClick,
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = description,
            tint = DarkGray,
        )
    }
}
