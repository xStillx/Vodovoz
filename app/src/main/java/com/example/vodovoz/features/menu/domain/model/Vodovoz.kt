package com.example.vodovoz.features.menu.domain.model


data class Vodovoz(
    val status: String,
    val message: String,
    val tovary: List<Tovary>
)

data class Tovary(
    val id: Long,
    val name: String,
    val data: List<Data>
)

data class Data(
    val id: String,
    val iblockId: String,
    val name: String?,
    val detailPicture: String,
    val extendedPrice: List<ExtendedPrice>
)

data class ExtendedPrice(
    val price: Int
)