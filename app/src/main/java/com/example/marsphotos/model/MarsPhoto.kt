package com.example.marsphotos.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable // make the class able to convert to & from JSON format
data class MarsPhoto(
    val id: String,
    // matches the "img_src" key in the JSON object
    // did this because Kotlin uses camelCase for property/variable naming not underscores
    @SerialName(value = "img_src")
    val imgSrc: String
)
