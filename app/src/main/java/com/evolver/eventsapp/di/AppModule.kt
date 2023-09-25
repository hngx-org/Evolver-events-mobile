package com.evolver.eventsapp.di

import com.evolver.eventsapp.network.EventApi
import com.evolver.eventsapp.ui.create_events.CreateEventRepositoryImpl
import com.evolver.eventsapp.ui.create_events.CreateRepository
import com.evolver.eventsapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /*@Provides
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
*/
    ///////////////////////////////////////////////////////////////////////////
    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.MINUTES )
            .connectTimeout(5, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()
    }

    @Singleton
    @Provides
    fun providesEventsApi(okHttpClient: OkHttpClient): EventApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EventApi::class.java)
    }

    @Singleton
    @Provides
    fun providesCreateEventRepository(api: EventApi): CreateRepository {
        return  CreateEventRepositoryImpl(api)
    }


}