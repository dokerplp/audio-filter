package com.dokerplp.message

data class ImageAndSoundMessage(
    val image: String,
    val audio: List<Double>,
    val filter: String
)
