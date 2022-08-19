package com.dokerplp.service

import com.dokerplp.message.ImageAndSoundMessage
import org.springframework.stereotype.Service
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

import kotlin.coroutines.*
import kotlin.math.max
import kotlin.math.min

@Service
class ImageAndSoundService(
    private val imageService: ImageService,
    private val audioService: AudioService
) {

    fun handle(imageAndSoundMessage: ImageAndSoundMessage): String {
        val audioValues = imageAndSoundMessage.audio
        val size = audioValues.size
        val audio = audioService.handleAudio(audioValues)
        return imageService.handleImage(imageAndSoundMessage.image, audio, size, getAlpha(audioValues))
        //imageService.handleImage(imageAndSoundMessage.image)
    }

    fun getAlpha(audioValues: List<Double>): Int {
        val loud = (audioValues.maxOrNull() ?: 0.0) * 228
        return min(loud.toInt(), 255)
    }
}