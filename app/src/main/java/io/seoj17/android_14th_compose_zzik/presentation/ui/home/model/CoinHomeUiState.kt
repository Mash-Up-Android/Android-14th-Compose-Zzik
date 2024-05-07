package io.seoj17.android_14th_compose_zzik.presentation.ui.home.model

import io.seoj17.android_14th_compose_zzik.data.model.CoinInfo
import io.seoj17.android_14th_compose_zzik.presentation.model.CoinTickerModel
import io.seoj17.android_14th_compose_zzik.presentation.utils.ImmutableList

data class CoinHomeUiState(
    val marketList: ImmutableList<CoinInfo>,
    val coinTickerList: ImmutableList<CoinTickerModel>,
    val isLoading: Boolean = true,
    val error: Throwable? = null,
)