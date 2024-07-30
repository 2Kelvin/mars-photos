package com.example.marsphotos.data

import com.example.marsphotos.network.MarsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * Contains all the dependencies the app requires.
 * These dependencies are accessible to all activities across the whole app
 */
interface AppContainer {
    val marsPhotosRepository: MarsPhotosRepository
}

/**
 * Class implements the AppContainer interface.
 * It's the official AppContainer class
 */
class DefaultAppContainer : AppContainer {
    /** * Mars API URI */
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com"

    // building a retrofit object
    private val retrofitObject = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build() // creates the retrofit object

    // lazy{} makes sure it's initialized at its first usage
    private val retrofitService : MarsApiService by lazy {
        retrofitObject.create(MarsApiService::class.java)
    }

    override val marsPhotosRepository: MarsPhotosRepository by lazy {
        NetworkMarsPhotosRepository(retrofitService)
    }
}