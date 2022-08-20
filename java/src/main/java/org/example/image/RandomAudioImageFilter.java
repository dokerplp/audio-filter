package org.example.image;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomAudioImageFilter extends BaseAudioImageFilter {

    public RandomAudioImageFilter(List<Double> audio) {
        super(audio);
    }

    private int getBound(int audio) {
        return 100 + Math.abs(audio) % 255;
    }

    private int incPosition(int position) {
        return (position + 1) % 256;
    }

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        int pos = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var a = 255;
                var r = ThreadLocalRandom.current().nextInt(0, getBound(audio.get(pos)));
                pos = incPosition(pos);
                var g = ThreadLocalRandom.current().nextInt(0, getBound(audio.get(pos)));
                pos = incPosition(pos);
                var b = ThreadLocalRandom.current().nextInt(0, getBound(audio.get(pos)));
                pos = incPosition(pos);

                var p = getArgbPixel(a, r, g, b);
                bfi.setRGB(x, y, p);
            }
        }
        return bufferedImageToString(bfi);
    }
}
