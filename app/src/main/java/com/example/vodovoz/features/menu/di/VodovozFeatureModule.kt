package com.example.vodovoz.features.menu.di

import com.example.vodovoz.features.menu.data.api.VodovozApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class FoodFeaturesModule {

    @Provides
    fun provideVodovozApi(retrofit: Retrofit) = retrofit.create(
        VodovozApi::class.java
    )
}