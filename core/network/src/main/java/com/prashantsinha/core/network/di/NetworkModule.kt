package com.prashantsinha.core.network.di

import com.prashantsinha.core.network.ContentService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class NetworkModule {

    fun contentService(): ContentService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build();

        return retrofit.create(ContentService::class.java);
    }
}