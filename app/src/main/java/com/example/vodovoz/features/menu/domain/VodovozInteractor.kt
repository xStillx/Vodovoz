package com.example.vodovoz.features.menu.domain

import com.example.vodovoz.features.menu.data.VodovozRepo
import com.example.vodovoz.utils.safeRequest
import javax.inject.Inject

class VodovozInteractor @Inject constructor(
    private val vodovozRepo: VodovozRepo
) {

    suspend fun getData() = safeRequest {
        vodovozRepo.getData()
    }
}