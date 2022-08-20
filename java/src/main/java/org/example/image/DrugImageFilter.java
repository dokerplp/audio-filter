package org.example.image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DrugImageFilter extends BaseImageFilter {

    private int rand(int l, int r) {
        return ThreadLocalRandom.current().nextInt(l, r);
    }

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        int i = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int color = bfi.getRGB(x, y);

                int r = (color & 0xff0000) >> 16;
                int g = (color & 0xff00) >> 8;
                int b = color & 0xff;

                r += i;
                i += 10;
                g += i;
                i += 20;
                b += i;
                i += 30;

                r %= 256;
                g %= 256;
                b %= 256;


                int a = 255;
                var p = getArgbPixel(a, r, g, b);

                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}
