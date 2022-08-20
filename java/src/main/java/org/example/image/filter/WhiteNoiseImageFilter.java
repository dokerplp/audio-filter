package org.example.image.filter;

import java.util.concurrent.ThreadLocalRandom;

public class WhiteNoiseImageFilter extends BaseImageFilter {

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();


        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var a = rand(0, 256);
                var r = rand(0, 256);
                var g = rand(0, 256);
                var b = rand(0, 256);
                var p = getArgbPixel(a, r, g, b);
                bfi.setRGB(x, y, p);
            }
        }
        return bufferedImageToString(bfi);
    }
}
