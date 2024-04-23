package io.seoj17.android_14th_compose_zzik.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.seoj17.android_14th_compose_zzik.ui.component.CoinNextButton
import io.seoj17.android_14th_compose_zzik.ui.component.CoinPreviousButton
import io.seoj17.android_14th_compose_zzik.ui.theme.CoinMainColor
import io.seoj17.android_14th_compose_zzik.ui.theme.CoinPriceUpColor

@Composable
fun CoinDetailScreen(
    onBackClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        CoinAppBar(
            title = "비트코인",
            onBackClick = onBackClick
        )
        CoinInfoTab()
        CoinCategoryTab(modifier = Modifier.padding(top = 10.dp))
        CoinPriceList()
    }
}

@Composable
fun CoinPriceList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
    ) {
        items(30) {
            CoinPriceItem()
            if (it != 29) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(1.dp),
                    color = Color.LightGray,
                )
            }
        }
    }
}

@Composable
fun CoinPriceItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(
                fontSize = 13.sp,
                text = "512.3",
                color = CoinPriceUpColor,
            )
            Text(
                modifier = Modifier.padding(end = 5.dp),
                fontSize = 11.sp,
                text = "12.67%",
                color = CoinPriceUpColor,
            )
        }
        
        Text(
            text = "19,876.112",
            color = Color.Black,
            fontSize = 12.sp,
        )
    }
}

@Composable
private fun CoinInfoTab(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        CoinPreviousButton(modifier = Modifier.weight(1f))
        CoinInfo(modifier = Modifier.weight(8f))
        CoinNextButton(modifier = Modifier.weight(1f))
    }
}

@Composable
private fun CoinCategoryTab(modifier: Modifier = Modifier) {
    val categoryList = listOf("주문", "호가", "차트", "시세", "정보")
    val (selectedCategory, setSelectedCategory) = remember { mutableStateOf("주문") }
    
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(CoinMainColor),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        categoryList.forEach { item ->
            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .clickable(
                        role = Role.Button,
                        onClick = { setSelectedCategory(item) },
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                    ),
                text = item,
                color = if (selectedCategory == item) {
                    Color.White
                } else {
                    Color.LightGray
                },
            )
        }
    }
}

@Composable
private fun CoinInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text(
            fontSize = 20.sp,
            text = "711.3",
            color = CoinPriceUpColor,
        )
        Row {
            Text(
                modifier = Modifier.padding(end = 5.dp),
                text = "6.67%",
                color = CoinPriceUpColor,
            )
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(15.dp)
                    .rotate(-90f),
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = null,
                tint = CoinPriceUpColor,
            )
            Text(
                text = "44.5",
                color = CoinPriceUpColor,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CoinAppBar(
    title: String,
    onBackClick: () -> Unit = {},
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 20.sp,
                color = CoinMainColor,
            )
        },
        navigationIcon = {
            Icon(
                modifier = Modifier.clickable(
                    role = Role.Button,
                    onClick = { onBackClick() },
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                ),
                imageVector = Icons.Filled.KeyboardArrowLeft,
                tint = CoinMainColor,
                contentDescription = null,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.White,
        )
    )
}