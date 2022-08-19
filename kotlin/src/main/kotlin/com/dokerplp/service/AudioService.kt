package com.dokerplp.service

import audio.AudioAnalyzer
import org.springframework.stereotype.Service

@Service
class AudioService {

    fun handleAudio(data: List<Double>): (Double) -> Double {
        val analyzer = AudioAnalyzer()
        val scalaFunc = analyzer.analyze(data.toDoubleArray())
        return { (x: Double) -> scalaFunc.apply(x) as Double }
    }
}
private operator fun Double.component1(): Double = this
