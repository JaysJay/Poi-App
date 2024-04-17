package com.sans.poi.di

import com.sans.poi.data.remote.POIApiService
import com.sans.poi.data.repository.POIRepository
import com.sans.poi.utility.Constant.API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePoiApi(
        client: OkHttpClient
    ): POIApiService {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(POIApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePoiRepository(
        api: POIApiService
    ): POIRepository {
        return POIRepository(api)
    }


}