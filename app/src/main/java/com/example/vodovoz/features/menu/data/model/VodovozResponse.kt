package com.example.vodovoz.features.menu.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VodovozResponse(
    val status: String,
    val message: String,
    @Json(name = "TOVARY")
    val tovary: List<TovaryRespone>
)

@JsonClass(generateAdapter = true)
data class TovaryRespone(
    @Json(name = "ID")
    val id: Long,
    @Json(name = "NAME")
    val name: String,
    val data: List<DataResponse>
)

@JsonClass(generateAdapter = true)
data class DataResponse(
    @Json(name = "ID")
    val id: String,
    @Json(name = "IBLOCK_ID")
    val iblockId: String,
    @Json(name = "NAME")
    val name: String?,
    @Json(name = "DETAIL_PICTURE")
    val detailPicture: String,
    @Json(name = "EXTENDED_PRICE")
    val extendedPrice: List<ExtendedPriceResponse>
)

@JsonClass(generateAdapter = true)
data class ExtendedPriceResponse(
    @Json(name = "PRICE")
    val price: Int
)