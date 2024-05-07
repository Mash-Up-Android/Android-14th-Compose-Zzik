package io.seoj17.android_14th_compose_zzik.data

import io.seoj17.android_14th_compose_zzik.data.dto.MarketCodeResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BitRepositoryImpl @Inject constructor(
    private val bitService: BitService
) : BitRepository {
    override suspend fun getMarketCodeList(): Flow<List<MarketCodeResponse>> = flow {
        val marketCodeList = bitService.getMarketCodeList()
        emit(marketCodeList)
    }
}
