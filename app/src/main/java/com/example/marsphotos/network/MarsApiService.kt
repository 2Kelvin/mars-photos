package com.example.marsphotos.network

import com.example.marsphotos.model.MarsPhoto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

/**
 * building a retrofit object
 */
private val retrofitObject = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build() // creates the retrofit object


/**
 * blueprint of how the retrofitObject should talk to the mars restful api server
 */
interface MarsApiService {
    /**
     *  make a GET http request to mars server for the "photos" endpoint
     *  get the JSON data, convert it to a kotlin objects of type <MarsPhoto> ...
     *  ... and getPhotos returns that list of MarsPhoto objects
     */
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

/**
 * one time instance MarsAPI object to access the retrofit MarsApiService
 * this object is to be accessed by the whole app
 */
object MarsApi {
    // lazy{} makes sure it's initialized at its first usage
    val retrofitService : MarsApiService by lazy {
        retrofitObject.create(MarsApiService::class.java)
    }
}