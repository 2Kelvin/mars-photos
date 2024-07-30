package com.example.marsphotos.fake

import com.example.marsphotos.model.MarsPhoto

object FakeDataSource {
    const val idOne = "img1"
    const val idTwo = "img2"
    const val imgOneUrl = "url.1"
    const val imgTwoUrl = "url.2"

    /** A list of two fake MarsPhoto images & their ids */
    val photoList = listOf(
        MarsPhoto(id = idOne, imgSrc = imgOneUrl),
        MarsPhoto(id = idTwo, imgSrc = imgTwoUrl)
    )
}