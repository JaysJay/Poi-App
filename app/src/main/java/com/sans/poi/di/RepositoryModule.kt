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
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePoiRepository(
        retrofit: Retrofit
    ): POIApiService = retrofit.create(POIApiService::class.java)


}