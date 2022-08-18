package com.dokerplp.service

import com.dokerplp.message.ImageAndSoundMessage
import org.springframework.stereotype.Service
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

import kotlin.coroutines.*

@Service
class ImageAndSoundService(
    private val imageService: ImageService,
    private val audioService: AudioService
) {

    fun handle(imageAndSoundMessage: ImageAndSoundMessage) {
        val executor = Executors.newFixedThreadPool(2)
        val tasks: List<Callable<Any>> = listOf(
            Callable<Any> {
                imageService.handleImage(imageAndSoundMessage.image)
            },
            Callable<Any> {
                audioService.handleAudio(imageAndSoundMessage.audio)
            }
        )
        executor.invokeAll(tasks)
        executor.shutdown()
    }
}