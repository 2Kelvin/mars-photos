package com.example.marsphotos.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Mars image object.
 *
 * It has two properties:
 * [id] The image's unique id in the list of Mars images and
 * [imgSrc] The image's URL.
 *
 * [Serializable] makes the data class (object) able to convert to & from JSON format.
 * [SerialName] matches the "img_src" key in the JSON object.
 * This is important because Kotlin uses camelCase for property/variable naming not underscores.
 * So the Kotlin imgSrc object property refers to the JSON's img_src as described in SerialName's value parameter
 */
@Serializable
data class MarsPhoto(
    val id: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)
