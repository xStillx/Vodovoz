package com.example.vodovoz.features.menu.data.model.mapper

import com.example.vodovoz.features.menu.data.model.VodovozResponse
import com.example.vodovoz.features.menu.domain.model.Vodovoz
import javax.inject.Inject

class VodovozMapper @Inject constructor(
    private val tovaryMapper: TovaryMapper
) {

    fun map(vodovozResponse: VodovozResponse) = Vodovoz(
        status = vodovozResponse.status,
        message = vodovozResponse.message,
        tovary = vodovozResponse.tovary.map {
            tovaryMapper.map(it)
        }
    )
}