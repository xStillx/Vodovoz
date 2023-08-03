package com.example.vodovoz.features.menu.data.model.mapper

import com.example.vodovoz.features.menu.data.model.ExtendedPriceResponse
import com.example.vodovoz.features.menu.domain.model.ExtendedPrice
import javax.inject.Inject

class ExtendedPriceMapper @Inject constructor() {

    fun map(extendedPriceResponse: ExtendedPriceResponse) = ExtendedPrice(
        price = extendedPriceResponse.price
    )
}