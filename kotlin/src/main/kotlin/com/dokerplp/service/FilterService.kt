package com.dokerplp.service

import org.example.image.ImageFilter
import org.example.image.audioFilter.CringeAudioImageFilter
import org.example.image.audioFilter.DrugAudioImageFilter
import org.example.image.audioFilter.WhiteNoiseAudioImageFilter
import org.example.image.filter.*
import org.springframework.stereotype.Service


@Service
class FilterService {

    fun getFilter(filter: String, audio: List<Double>): ImageFilter {
        return when (filter) {
            "default" -> DefaultImageFilter()
            "negative" -> NegativeImageFilter()
            "purple-negative" -> PurpleNegativeImageFilter()
            "green-negative" -> GreenNegativeImageFilter()
            "black-negative" -> BlackNegativeImageFilter()
            "drug" -> DrugImageFilter()
            "red" -> RedImageFilter()
            "black-white" -> BlackAndWhiteImageFilter()
            "sepia" -> SepiaImageFilter()
            "absolute" -> AbsoluteImageFilter()
            "anti-absolute" -> AntiAbsoluteImageFilter()
            "white-noise" -> WhiteNoiseImageFilter()
            "white-noise-2" -> WhiteNoise2ImageFilter()
            "drug-audio" -> DrugAudioImageFilter(audio)
            "white-noise-audio" -> WhiteNoiseAudioImageFilter(audio)
            "cringe-audio" -> CringeAudioImageFilter(audio)
            else -> DefaultImageFilter()
        }
    }
}