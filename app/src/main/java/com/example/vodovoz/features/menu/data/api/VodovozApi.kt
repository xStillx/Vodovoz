package com.example.vodovoz.features.menu.data.api

import com.example.vodovoz.features.menu.data.model.VodovozResponse
import retrofit2.http.GET

interface VodovozApi {

    @GET("newmobile/glavnaya/super_top.php?action=topglav")
    suspend fun getData(): VodovozResponse
}