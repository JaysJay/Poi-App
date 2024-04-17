package com.sans.poi.di

import android.app.Application
import android.content.Context
import com.sans.poi.data.remote.POIApiService
import com.sans.poi.data.remote.dataSource.POIRemoteDataSource
import com.sans.poi.utility.Header
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideContext(application: Application) : Context = application

    @Singleton
    @Provides
    fun provideRemoteSource(
        api: POIApiService,
        header: Header
    ) = POIRemoteDataSource(api,header)
}