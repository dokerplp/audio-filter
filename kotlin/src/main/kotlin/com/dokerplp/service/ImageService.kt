package com.dokerplp.service

import org.example.image.AbsoluteImageFilter
import org.example.image.AntiAbsoluteImageFilter
import org.example.image.DrugImageFilter
import org.example.image.RandomAudioImageFilter
import org.example.image.RedImageFilter
import org.example.image.SimpleAudioImageFilter
import org.springframework.stereotype.Service
import java.io.*
import java.util.*


@Service
class ImageService {

    fun handleImage(image: String): String {
        val filter = RedImageFilter()
        return filter.filter(image)
    }

    fun handleImage(image: String, audio: List<Double>): String {
        val filter = DrugImageFilter()
        return filter.filter(image)
    }

}