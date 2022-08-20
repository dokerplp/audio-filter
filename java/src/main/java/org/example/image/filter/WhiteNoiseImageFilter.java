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
                var a = ThreadLocalRandom.current().nextInt(0, 256);
                var r = ThreadLocalRandom.current().nextInt(0, 256);
                var g = ThreadLocalRandom.current().nextInt(0, 256);
                var b = ThreadLocalRandom.current().nextInt(0, 256);
                var p = getArgbPixel(a, r, g, b);
                bfi.setRGB(x, y, p);
            }
        }
        return bufferedImageToString(bfi);
    }
}
