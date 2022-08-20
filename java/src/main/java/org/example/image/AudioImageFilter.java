package org.example.image;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AudioImageFilter extends BaseImageFilter {

    private final List<Double> audio;

    public AudioImageFilter(List<Double> audio) {
        this.audio = audio;
    }

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                int color = bfi.getRGB(x, y);

                int r = (color & 0xff0000) >> 16;
                int g = (color & 0xff00) >> 8;
                int b = color & 0xff;
                int a = 255;

                g = 0;
                b = 0;

                var p = getArgbPixel(a, r, g, b);

                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}
