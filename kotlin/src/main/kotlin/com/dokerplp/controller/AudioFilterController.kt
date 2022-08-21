package com.dokerplp.controller

import com.dokerplp.message.ImageAndSoundMessage
import com.dokerplp.service.ImageAndSoundService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AudioFilterController(
    private val imageAndSoundService: ImageAndSoundService
) {

    @CrossOrigin
    @PostMapping("/audio-filter")
    fun audioFilter(@RequestBody imageAndSound: ImageAndSoundMessage): String {
        return imageAndSoundService.handle(imageAndSound)
    }
}