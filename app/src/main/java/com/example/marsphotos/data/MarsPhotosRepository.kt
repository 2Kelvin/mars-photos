package com.example.marsphotos.data

import com.example.marsphotos.network.MarsApi
import com.example.marsphotos.model.MarsPhoto

/**
 * main repository for the api data
 * this is the data layer
 */
interface MarsPhotosRepository  {
    /**
     * Fetches data from mars api server & returns a list of MarsPhoto objects.
     * In class NetworkMarsPhotosRepository, this function uses Retrofit library
     * to fetch the mars photo data from the api.
     */
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

/**
 * implements the MarsPhotosRepository interface
 */
class NetworkMarsPhotosRepository(): MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return MarsApi.retrofitService.getPhotos()
    }
}