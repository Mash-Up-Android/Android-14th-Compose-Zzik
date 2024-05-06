package io.seoj17.android_14th_compose_zzik.data

import io.seoj17.android_14th_compose_zzik.data.dto.MarketCodeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BitService {

    @GET("v1/market/all")
    suspend fun getMarketCodeList(
        @Query("isDetails") isDetails: Boolean = false
    ): List<MarketCodeResponse>
}
