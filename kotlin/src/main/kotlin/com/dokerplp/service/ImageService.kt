package com.dokerplp.service

import org.example.image.audioFilter.RandomAudioImageFilter
import org.example.image.filter.AverageImageFilter
import org.example.image.filter.RedImageFilter
import org.example.image.filter.WhiteNoise2ImageFilter
import org.springframework.stereotype.Service

@Service
class ImageService {

    fun handleImage(image: String): String {
        val filter = RedImageFilter()
        return filter.filter(image)
    }

    fun handleImage(image: String, audio: List<Double>): String {
        val filter = AverageImageFilter()
        return filter.filter(image)
    }

}