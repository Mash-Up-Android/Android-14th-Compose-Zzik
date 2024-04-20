package io.seoj17.android_14th_compose_zzik.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.seoj17.android_14th_compose_zzik.R
import io.seoj17.android_14th_compose_zzik.ui.theme.DarkGray
import io.seoj17.android_14th_compose_zzik.ui.theme.Gray
import io.seoj17.android_14th_compose_zzik.ui.theme.Transparent
import io.seoj17.android_14th_compose_zzik.ui.theme.White

val SearchBarHeight = 54.dp

@Composable
fun UpBitSearchBar(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    onTextChange: (String) -> Unit = {},
    onSearchClick: () -> Unit = {},
) {

    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(SearchBarHeight),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = modifier.padding(start = 10.dp),
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = Gray,
            )
            TextField(
                value = text,
                onValueChange = onTextChange,
                modifier = modifier.weight(1f),
                placeholder = {
                    Text(
                        text = hint,
                        color = DarkGray,
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Transparent,
                    unfocusedContainerColor = Transparent,
                    disabledContainerColor = Transparent,
                    focusedIndicatorColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    disabledIndicatorColor = Transparent,
                    focusedTextColor = White,
                    unfocusedTextColor = White,
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { onSearchClick() }),
            )

        }
        Divider(
            modifier = modifier
                .fillMaxWidth()
                .height(2.dp),
            color = Gray
        )
    }
}

@Composable
@Preview
fun UpBitSearchBarPreview(

) {
    UpBitSearchBar()
}
