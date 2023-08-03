package com.example.vodovoz.features.menu.data.model.mapper

import com.example.vodovoz.features.menu.data.model.TovaryRespone
import com.example.vodovoz.features.menu.domain.model.Tovary
import javax.inject.Inject

class TovaryMapper @Inject constructor(
    private val dataMapper: DataMapper
) {

    fun map(tovaryRespone: TovaryRespone) = Tovary(
        id = tovaryRespone.id,
        name = tovaryRespone.name,
        data = tovaryRespone.data.map {
            dataMapper.map(it)
        }
    )
}