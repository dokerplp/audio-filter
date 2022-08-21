package com.dokerplp.service

import com.dokerplp.message.ImageAndSoundMessage
import org.springframework.stereotype.Service

@Service
class ImageAndSoundService(
    private val imageService: ImageService,
) {

    fun handle(imageAndSoundMessage: ImageAndSoundMessage): String {
        //val audioValues = imageAndSoundMessage.audio
        //val size = audioValues.size
        //val audio = audioService.handleAudio(audioValues)
        //return imageService.handleImage(imageAndSoundMessage.image, audio, size, getAlpha(audioValues))
        //return imageService.handleImage(imageAndSoundMessage.image)
        return imageService.handleImage(
            imageAndSoundMessage.image,
            imageAndSoundMessage.audio,
            imageAndSoundMessage.filter
        )
    }
}