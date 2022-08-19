package com.dokerplp.service

import jakarta.xml.bind.DatatypeConverter
import org.springframework.stereotype.Service
import java.awt.image.BufferedImage
import java.io.*
import java.util.*
import javax.imageio.ImageIO
import kotlin.math.abs


@Service
class ImageService {

    private val userDir = System.getProperty("user.dir")
    private var count = 1;
    private val path = "$userDir/img/img.png"

    fun handleImage(dataUrl: String) {
        parseBase64(dataUrl)
    }

    fun handleImage(dataUrl: String, audio: (Double) -> Double, size: Int, alpha: Int): String {
        val img = parseBase64Req(dataUrl)
        val filtered = parseBase64(img, audio, size, alpha)
        return parseBase64Resp(filtered)
    }

    fun parseBase64Req(img: String): String = img.split(",")[1]

    fun parseBase64Resp(img: String): String = "data:image/png;base64,$img"

    fun parseBase64(img: String) {
        try {
            val decodedBytes: ByteArray = DatatypeConverter.parseBase64Binary(img)
            val bfi = ImageIO.read(ByteArrayInputStream(decodedBytes))
            val file = File(path)
            ImageIO.write(bfi, "png", file)
            bfi.flush()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun parseBase64(img: String, audio: (Double) -> Double, size: Int, alpha: Int): String {
        try {
            val decodedBytes: ByteArray = DatatypeConverter.parseBase64Binary(img)
            val bfi = ImageIO.read(ByteArrayInputStream(decodedBytes))

            val width = bfi.width
            val height = bfi.height

//            var pos = 0.0
//            for (y in 0 until height) {
//                for (x in 0 until width) {
//
//                    val rgb = bfi.getRGB(x, y)
//                    var r = rgb and 0xff0000 shr 16
//                    var g = rgb and 0xff00 shr 8
//                    var b = rgb and 0xff
//
//                    r = filterPixel(r, audio(pos++ % size))
//                    g = filterPixel(g, audio(pos++ % size))
//                    b = filterPixel(b, audio(pos++ % size))
//
//                    val p = alpha shl 24 or (r shl 16) or (g shl 8) or b //pixel
//                    bfi.setRGB(x, y, p)
//                }
//            }

            val os = ByteArrayOutputStream()
            ImageIO.write(bfi, "png", os)
            bfi.flush()

            return Base64.getEncoder().encodeToString(os.toByteArray())
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun filterPixel(color: Int, change: Double): Int {
        return (color + abs(change).toInt()) % 256
    }

    fun createFilter() {
        val width = 640
        val height = 320

        val bfi = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)

        for (y in 0 until height) {
            for (x in 0 until width) {
                val a = (Math.random() * 256).toInt() //generating
                val r = (Math.random() * 256).toInt() //values
                val g = (Math.random() * 256).toInt() //less than
                val b = (Math.random() * 256).toInt() //256
                val p = a shl 24 or (r shl 16) or (g shl 8) or b //pixel
                bfi.setRGB(x, y, p)
            }
        }

        try {
            val f = File("$userDir/filter.png")
            ImageIO.write(bfi, "png", f)
        } catch (e: IOException) {
            println("Error: $e")
        }
    }

}