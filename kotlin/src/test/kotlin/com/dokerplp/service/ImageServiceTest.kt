package com.dokerplp.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ImageServiceTest {

    @Autowired
    private lateinit var imageService: ImageService

    @Test
    fun createFilter() {
        imageService.createFilter()
    }
}