package com.dokerplp.service

import audio.AudioAnalyzer
import org.springframework.stereotype.Service

@Service
class AudioService {

    fun func(data: List<Double>) {
        val analyzer = AudioAnalyzer()
        val f = analyzer.analyze(data.toDoubleArray())
        println(f.apply(4.0))
    }
}