package io.seoj17.android_14th_compose_zzik.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.seoj17.android_14th_compose_zzik.data.model.CoinInfo
import io.seoj17.android_14th_compose_zzik.data.repository.UpBitRepository
import io.seoj17.android_14th_compose_zzik.presentation.model.CoinTickerModel
import io.seoj17.android_14th_compose_zzik.presentation.ui.home.model.CoinHomeUiState
import io.seoj17.android_14th_compose_zzik.presentation.utils.ImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UpBitRepository,
) : ViewModel() {

    private val _coinHomeUiState: MutableStateFlow<CoinHomeUiState> =
        MutableStateFlow(
            CoinHomeUiState(
                marketList = ImmutableList(),
                coinTickerList = ImmutableList(),
            )
        )
    val coinHomeUiState: StateFlow<CoinHomeUiState> = _coinHomeUiState.stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue = _coinHomeUiState.value
    )

    init {
        viewModelScope.launch {
            val marketList = repository.getAllMarketCode(true)
            _coinHomeUiState.update {
                it.copy(
                    marketList = ImmutableList(marketList),
                    coinTickerList = ImmutableList(initCoinInfoList(marketList)),
                )
            }
        }
    }

    fun startCoinRealTime() {
        viewModelScope.launch {
            val coinTickerFlow =
                repository.startRealTimeCoinInfo(coinHomeUiState.value.marketList.list)
            coinTickerFlow.collectLatest { coinTicker ->
                _coinHomeUiState.update {
                    it.copy(
                        coinTickerList = ImmutableList(
                            it.coinTickerList.list.map { coin ->
                                if (coin.marketCode == coinTicker.marketCode) {
                                    coin.copy(
                                        currentPrice = coinTicker.currentPrice,
                                        changePrice = coinTicker.changePrice,
                                        tradePrice24H = coinTicker.tradePrice24H,
                                    )
                                } else {
                                    coin
                                }
                            }
                        ),
                    )
                }
            }
        }
    }

    private fun initCoinInfoList(marketList: List<CoinInfo>): List<CoinTickerModel> {
        return marketList.map { coinInfo ->
            CoinTickerModel(
                coinName = coinInfo.name,
                marketCode = coinInfo.marketCode,
                currentPrice = 0.0,
                changePrice = 0.0,
                tradePrice24H = 0.0,
            )
        }
    }
}
