package com.example.marsphotos.fake

import com.example.marsphotos.model.MarsPhoto
import com.example.marsphotos.network.MarsApiService

class FakeMarsApiService : MarsApiService {

    /** Returns the fake list of the two Mars photos */
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photoList
    }
}