package com.dokerplp.service

import org.example.image.filter.RedImageFilter
import org.example.strategy.FiltersStrategy
import org.springframework.stereotype.Service

@Service
class ImageService {

    fun handleImage(image: String): String {
        val filter = RedImageFilter()
        return filter.filter(image)
    }

    fun handleImage(image: String, audio: List<Double>, filter: String): String {
        val filterImage = FiltersStrategy().getFilter(filter, audio)
        return filterImage.filter(image)
    }

}