package io.seoj17.android_14th_compose_zzik.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.seoj17.android_14th_compose_zzik.R
import io.seoj17.android_14th_compose_zzik.ui.theme.BitBlueColor
import io.seoj17.android_14th_compose_zzik.ui.theme.BitWhiteColor

@Composable
fun BitTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit = {},
    hint: String,
    onDoneClicked: () -> Unit = {},
    fontSize: Int,
    maxLength: Int = 0
) {
    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = {
            if (maxLength > 0 && it.length <= maxLength) {
                onValueChanged(it)
            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onDone = { onDoneClicked() }),
        textStyle = TextStyle(
            fontSize = fontSize.sp,
            color = BitWhiteColor
        ),
        cursorBrush = SolidColor(BitBlueColor),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
            ) {
                Icon(
                    modifier = Modifier.padding(start = 10.dp, end = 6.dp),
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search",
                    tint = BitWhiteColor
                )
                Box {
                    if (value.isEmpty()) {
                        Text(text = hint, fontSize = fontSize.sp, color = BitWhiteColor)
                    }
                    innerTextField()
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewBitTextField() {
    Column(modifier = Modifier.fillMaxWidth()) {
        var text by remember { mutableStateOf("") }

        BitTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChanged = { text = it },
            hint = "코인명/심볼 검색",
            fontSize = 16,
            maxLength = 100,
        )
    }
}
