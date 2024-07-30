package com.example.marsphotos

import com.example.marsphotos.data.NetworkMarsPhotosRepository
import com.example.marsphotos.fake.FakeDataSource
import com.example.marsphotos.fake.FakeMarsApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMarsRepositoryTest {

    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() = runTest {
        // runTest() runs this code in a coroutineScope
        // we need to do this because getMarsPhotos is a coroutine suspend function
        val repository = NetworkMarsPhotosRepository(
            marsApiService = FakeMarsApiService() // an instance of the FakeMarsApiService class
        )

        assertEquals(FakeDataSource.photoList, repository.getMarsPhotos())
    }
}