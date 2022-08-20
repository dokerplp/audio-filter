package org.example.image.audioFilter;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomAudioImageFilter extends BaseAudioImageFilter {

    public RandomAudioImageFilter(List<Double> audio) {
        super(audio);
    }


    private int position(int i) {
        return rand(0, Math.abs(audio.get(i)) + 1) % 256;
    }

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        int i = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var rgb = new RGB(255, bfi.getRGB(x, y));

                int rand = rand(0, 3);
                switch (rand) {
                    case 0 -> rgb.setR(position(i));
                    case 1 -> rgb.setG(position(i));
                    case 2 -> rgb.setB(position(i));
                }
                i += rand(0, 20);
                i %= audio.size();


                var p = getArgbPixel(rgb.getA(), rgb.getR(), rgb.getG(), rgb.getB());
                bfi.setRGB(x, y, p);
            }
        }
        return bufferedImageToString(bfi);
    }
}
