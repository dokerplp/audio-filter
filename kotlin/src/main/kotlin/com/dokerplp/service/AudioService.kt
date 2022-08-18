package com.dokerplp.service

import audio.AudioAnalyzer
import org.springframework.stereotype.Service

@Service
class AudioService {

    fun handleAudio(data: List<Double>) {

    }

    fun func(data: List<Double>) {
        val analyzer = AudioAnalyzer()
        val f = analyzer.analyze(data.toDoubleArray())
    }
}