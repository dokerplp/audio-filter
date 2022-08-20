package com.dokerplp.service

import jakarta.xml.bind.DatatypeConverter
import org.example.image.WhiteNoiseImageFilter
import org.springframework.stereotype.Service
import java.awt.image.BufferedImage
import java.io.*
import java.util.*
import javax.imageio.ImageIO
import kotlin.math.abs


@Service
class ImageService {

    fun handleImage(image: String): String {
        val filter = WhiteNoiseImageFilter()
        return filter.filter(image)
    }

}