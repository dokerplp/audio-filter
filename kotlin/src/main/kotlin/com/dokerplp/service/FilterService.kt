package com.dokerplp.service

import org.example.image.ImageFilter
import org.example.image.audioFilter.DrugAudioImageFilter
import org.example.image.audioFilter.RandomAudioImageFilter
import org.example.image.audioFilter.SimpleAudioImageFilter
import org.example.image.filter.AbsoluteImageFilter
import org.example.image.filter.AntiAbsoluteImageFilter
import org.example.image.filter.AntiSimpleImageFilter
import org.example.image.filter.DrugImageFilter
import org.example.image.filter.RedImageFilter
import org.example.image.filter.SimpleImageFilter
import org.example.image.filter.WhiteNoise2ImageFilter
import org.example.image.filter.WhiteNoiseImageFilter
import org.springframework.stereotype.Service


@Service
class FilterService {

    fun getFilter(filter: String, audio: List<Double>): ImageFilter {
        return when (filter) {
            "default" -> SimpleImageFilter()
            "anti-default" -> AntiSimpleImageFilter()
            "absolute" -> AbsoluteImageFilter()
            "anti-absolute" -> AntiAbsoluteImageFilter()
            "drug" -> DrugImageFilter()
            "red" -> RedImageFilter()
            "white-noise" -> WhiteNoiseImageFilter()
            "white-noise-2" -> WhiteNoise2ImageFilter()
            "drug-audio" -> DrugAudioImageFilter(audio)
            "random-audio" -> RandomAudioImageFilter(audio)
            "simple-audio" -> SimpleAudioImageFilter(audio)
            else -> SimpleImageFilter()
        }
    }
}