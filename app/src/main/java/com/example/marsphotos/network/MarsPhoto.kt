package com.example.marsphotos.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable // make the class able to convert to & from JSON format
data class MarsPhoto(
    val id: String,
    @SerialName(value = "img_src") // matches the "img_src" key in the JSON object (did this because Kotlin uses camelCase for property/variable naming not underscores
    val imgSrc: String
)
