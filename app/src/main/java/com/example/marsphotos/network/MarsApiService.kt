package com.example.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

/**
 * building a retrofit object
 */
private val retrofitObject = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create()) // then converting the JSON response gotten from the server to a String
    .baseUrl(BASE_URL)
    .build() // creates the retrofit object


/**
 * blueprint of how the retrofitObject should talk to the mars restful api server
 */
interface MarsApiService {
    /**
     *  make a GET http request to mars server for the "photos" endpoint
     *  get the JSON data, convert it to a string and getPhotos returns that string
     */
    @GET("photos")
    suspend fun getPhotos(): String
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