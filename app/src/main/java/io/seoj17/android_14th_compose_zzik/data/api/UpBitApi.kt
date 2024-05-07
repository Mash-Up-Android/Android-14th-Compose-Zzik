package io.seoj17.android_14th_compose_zzik.data.api

import io.seoj17.android_14th_compose_zzik.data.api.reseponse.MarketCoinInfoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UpBitApi {
    @GET("v1/market/all")
    suspend fun getAllMarketCode(@Query("isDetails") isDetails: Boolean): List<MarketCoinInfoResponse>
}