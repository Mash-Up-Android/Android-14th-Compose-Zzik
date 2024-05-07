package io.seoj17.android_14th_compose_zzik.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MarketCodeResponse(
    @Json(name = "market")
    val market: String,
    @Json(name = "korean_name")
    val korName: String
)
