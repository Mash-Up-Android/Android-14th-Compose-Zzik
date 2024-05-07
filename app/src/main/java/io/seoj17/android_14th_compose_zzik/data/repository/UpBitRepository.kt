package io.seoj17.android_14th_compose_zzik.data.repository

import android.util.Log
import io.seoj17.android_14th_compose_zzik.data.api.UpBitApi
import io.seoj17.android_14th_compose_zzik.data.model.CoinInfo
import io.seoj17.android_14th_compose_zzik.data.model.CoinTicker
import io.seoj17.android_14th_compose_zzik.data.model.toMarketCode
import io.seoj17.android_14th_compose_zzik.data.quilifier.UpBitWebSocketRequest
import io.seoj17.android_14th_compose_zzik.data.websocket.WebSocketListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject

class UpBitRepository @Inject constructor(
    @UpBitWebSocketRequest private val webSocketRequest: Request,
    private val upBitApi: UpBitApi,
    private val client: OkHttpClient,
) {

    fun startRealTimeCoinInfo(
        marketList: List<CoinInfo>,
    ): Flow<CoinTicker> {
        return callbackFlow {
            with(client) {
                newWebSocket(
                    webSocketRequest,
                    WebSocketListener(
                        coinCodeList = marketList,
                        onTickerResult = { coinTicker ->
                            trySend(coinTicker)
                        }
                    )
                )
            }
            awaitClose {
                Log.d("UpBitRepository", "close")
                close()
            }
        }
    }

    suspend fun getAllMarketCode(isDetails: Boolean): List<CoinInfo> {
        return upBitApi
            .getAllMarketCode(isDetails)
            .toMarketCode()
            .filter { it.marketCode.contains("KRW") }
    }
}
