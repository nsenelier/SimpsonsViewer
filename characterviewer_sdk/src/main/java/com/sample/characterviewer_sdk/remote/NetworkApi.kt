package com.sample.characterviewer_sdk.remote

import com.google.gson.Gson
import com.sample.characterviewer_sdk.remote.CharacterApi
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

interface NetworkApi {
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient
    fun providesRetrofit(gson: Gson, okHttpClient: OkHttpClient): CharacterApi
    fun providesGson(): Gson
    fun provideRepository(
        characterApi: CharacterApi,
        ioDispatcher: CoroutineDispatcher
    ): CharacterRepository

    fun providesIODispatcher(): CoroutineDispatcher
}