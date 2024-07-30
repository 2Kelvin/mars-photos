package com.example.marsphotos.network

import com.example.marsphotos.model.MarsPhoto
import retrofit2.http.GET


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