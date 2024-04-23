package io.seoj17.android_14th_compose_zzik.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.seoj17.android_14th_compose_zzik.R
import io.seoj17.android_14th_compose_zzik.ui.theme.Blue
import io.seoj17.android_14th_compose_zzik.ui.theme.DarkGray

@Composable
fun UpBitRadioButton(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    size: Int,
    index: Int,
    description: String,
    onRadioClick: (Int) -> Unit = {},
) {
    val iconId =
        if (isChecked) R.drawable.ic_radio_button_checked else R.drawable.ic_radio_button_unchecked
    val buttonTint = if (isChecked) Blue else DarkGray

    IconButton(
        modifier = modifier.size(size.dp),
        onClick = { onRadioClick(index) },
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = description,
            tint = buttonTint,
        )
    }
}
