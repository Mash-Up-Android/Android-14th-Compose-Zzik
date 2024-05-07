package io.seoj17.android_14th_compose_zzik.data.websocket

import io.seoj17.android_14th_compose_zzik.data.model.CoinTicker
import kotlinx.coroutines.flow.Flow

fun interface WebSocketMessage {
    fun onTickerMessage(ticker: CoinTicker): Flow<CoinTicker>
}