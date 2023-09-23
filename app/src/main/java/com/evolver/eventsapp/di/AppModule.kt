package com.evolver.eventsapp.di

import com.evolver.eventsapp.network.EventApi
import com.evolver.eventsapp.utils.BASE_URL
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
object AppModule {

    @Provides
    @Singleton
    fun provideEventApi() : EventApi {
        val okHttpClient = OkHttpClient.Builder()
           // .addInterceptor(TimeoutInterceptor()) // Add the TimeoutInterceptor here
            .build()
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EventApi::class.java)
    }
}