package com.dokerplp.service

import org.example.image.filter.RedImageFilter
import org.example.image.filter.WhiteNoise2ImageFilter
import org.springframework.stereotype.Service

@Service
class ImageService(
    private val filterService: FilterService
) {

    fun handleImage(image: String): String {
        val filter = RedImageFilter()
        return filter.filter(image)
    }

    fun handleImage(image: String, audio: List<Double>, filter: String): String {
        val filterImage = filterService.getFilter(filter, audio)
        return filterImage.filter(image)
    }

}