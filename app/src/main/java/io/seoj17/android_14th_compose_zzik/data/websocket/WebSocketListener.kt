package io.seoj17.android_14th_compose_zzik.data.websocket

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.seoj17.android_14th_compose_zzik.data.api.reseponse.TickerResponse
import io.seoj17.android_14th_compose_zzik.data.model.CoinInfo
import io.seoj17.android_14th_compose_zzik.data.model.CoinTicker
import io.seoj17.android_14th_compose_zzik.data.model.toCoinTicker
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import java.util.UUID

class WebSocketListener(
    private val coinCodeList: List<CoinInfo>,
    private val onTickerResult: (CoinTicker) -> Unit,
) : WebSocketListener() {

    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
        Log.d("Socket", "onOpen : ${response.message}")
        val uniqueTicket = UUID.randomUUID().toString()
        webSocket.send(
            "[{\"ticket\":\"${uniqueTicket}\"},{\"type\":\"ticker\",\"codes\":[${
                coinCodeList.joinToString(
                    ", "
                ) { "\"${it.marketCode}\"" }
            }]}]"
        )
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
        Log.d("Socket", "onMessage : $text")
        webSocket.close(NORMAL_CLOSURE_STATUS, null)
        webSocket.cancel()
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        super.onMessage(webSocket, bytes)
        //Log.d("Socket", "onMessage : ${bytes.utf8()}")
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter = moshi.adapter(TickerResponse::class.java)
        val result = adapter.fromJson(bytes.utf8())

        //Log.d("Socket", "onMessage : ${result}")
        result?.let {
            onTickerResult(it.toCoinTicker())
        }
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosing(webSocket, code, reason)
        Log.d("Socket", "onClosing : $reason")
        webSocket.close(NORMAL_CLOSURE_STATUS, null)
        webSocket.cancel()
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        super.onFailure(webSocket, t, response)
        Log.d("Socket", "onFailure : ${t.message}")
        Log.d("Socket", "onFailure : ${response?.message}")
    }

    companion object {
        const val NORMAL_CLOSURE_STATUS = 1000
    }
}
