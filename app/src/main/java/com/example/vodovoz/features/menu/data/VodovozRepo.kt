package com.example.vodovoz.features.menu.data

import com.example.vodovoz.features.menu.data.api.VodovozApi
import com.example.vodovoz.features.menu.data.model.mapper.VodovozMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VodovozRepo @Inject constructor(
    private val vodovozApi: VodovozApi,
    private val vodovozMapper: VodovozMapper
) {

    suspend fun getData() = withContext(Dispatchers.IO){
        vodovozApi.getData().let {
            vodovozMapper.map(it)
        }
    }
}