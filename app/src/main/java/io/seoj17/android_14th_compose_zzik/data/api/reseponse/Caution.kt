package io.seoj17.android_14th_compose_zzik.data.api.reseponse


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Caution(
    @Json(name = "CONCENTRATION_OF_SMALL_ACCOUNTS")
    val cONCENTRATIONOFSMALLACCOUNTS: Boolean,
    @Json(name = "DEPOSIT_AMOUNT_SOARING")
    val dEPOSITAMOUNTSOARING: Boolean,
    @Json(name = "GLOBAL_PRICE_DIFFERENCES")
    val gLOBALPRICEDIFFERENCES: Boolean,
    @Json(name = "PRICE_FLUCTUATIONS")
    val pRICEFLUCTUATIONS: Boolean,
    @Json(name = "TRADING_VOLUME_SOARING")
    val tRADINGVOLUMESOARING: Boolean
)