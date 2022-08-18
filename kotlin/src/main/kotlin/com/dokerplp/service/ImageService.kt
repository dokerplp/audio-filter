package com.dokerplp.service

import jakarta.xml.bind.DatatypeConverter
import org.apache.tomcat.util.codec.binary.Base64
import org.springframework.stereotype.Service
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileOutputStream
import javax.imageio.ImageIO


@Service
class ImageService {

    private val userDir = System.getProperty("user.dir")
    private val path = "$userDir/img.png"

    fun parseBase64(dataUrl: String) {
        try {
            val dataWithoutHeader = dataUrl.split(",")[1]
            val decodedBytes: ByteArray = DatatypeConverter.parseBase64Binary(dataWithoutHeader)
            val bfi = ImageIO.read(ByteArrayInputStream(decodedBytes))
            val file = File(path)
            ImageIO.write(bfi, "png", file)
            bfi.flush()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}