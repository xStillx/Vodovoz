package com.example.vodovoz.features.menu.data.model.mapper

import com.example.vodovoz.features.menu.data.model.DataResponse
import com.example.vodovoz.features.menu.domain.model.Data
import javax.inject.Inject

class DataMapper @Inject constructor(
    private val extendedPriceMapper: ExtendedPriceMapper
) {

    fun map(dataResponse: DataResponse) = Data(
        id = dataResponse.id,
        iblockId = dataResponse.iblockId,
        name = dataResponse.name,
        detailPicture = dataResponse.detailPicture,
        extendedPrice = dataResponse.extendedPrice.map {
            extendedPriceMapper.map(it)
        }
    )
}