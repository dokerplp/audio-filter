package org.example.image;

import jakarta.xml.bind.DatatypeConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public abstract class BaseImageFilter implements ImageFilter {

    private BufferedImage parseBase64(String image) {
        try {
            byte[] bytes = DatatypeConverter.parseBase64Binary(image);
            return ImageIO.read(new ByteArrayInputStream(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String unpackImage(String image) {
        return image.split(",")[1];
    }

    private String packImage(String image) {
        return String.format("data:image/png;base64,%s", image);
    }

    protected BufferedImage stringToBufferedImage(String image) {
        return parseBase64(unpackImage(image));
    }

    protected String bufferedImageToString(BufferedImage bfi) {
        try {
            var os = new ByteArrayOutputStream();
            ImageIO.write(bfi, "png", os);
            bfi.flush();
            String image = Base64.getEncoder().encodeToString(os.toByteArray());
            return packImage(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected int getArgbPixel(int a, int r, int g, int b) {
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    protected void saveImage(BufferedImage bfi, String path, String format) {
        try {
            var file = new File(path);
            ImageIO.write(bfi, format, file);
            bfi.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
