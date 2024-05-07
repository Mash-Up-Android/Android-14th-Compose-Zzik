package io.seoj17.android_14th_compose_zzik.data

import io.seoj17.android_14th_compose_zzik.data.dto.MarketCodeResponse
import kotlinx.coroutines.flow.Flow

interface BitRepository {
    suspend fun getMarketCodeList(): Flow<List<MarketCodeResponse>>
}
