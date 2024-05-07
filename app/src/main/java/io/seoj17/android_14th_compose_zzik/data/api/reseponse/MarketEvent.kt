package io.seoj17.android_14th_compose_zzik.data.api.reseponse


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MarketEvent(
    @Json(name = "caution")
    val caution: Caution,
    @Json(name = "warning")
    val warning: Boolean
)