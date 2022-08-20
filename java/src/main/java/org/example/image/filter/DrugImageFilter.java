package org.example.image.filter;

import java.util.concurrent.ThreadLocalRandom;

public class DrugImageFilter extends BaseImageFilter {

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        int i = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var rgb = new RGB(255, bfi.getRGB(x, y));

                rgb.incR(i);
                i += 10;
                rgb.incG(i);
                i += 20;
                rgb.incB(i);
                i += 30;

                var p = getArgbPixel(rgb.getA(), rgb.getR(), rgb.getG(), rgb.getB());
                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}
