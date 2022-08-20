package org.example.image.filter;

import org.example.image.filter.BaseImageFilter;

public class AntiSimpleImageFilter extends BaseImageFilter {
    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        int i = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int color = bfi.getRGB(x, y);

                int r = 255 - (color & 0xff0000) >> 16;
                int g = 255 - (color & 0xff00) >> 8;
                int b = 255 - color & 0xff;

                int a = 255;
                var p = getArgbPixel(a, r, g, b);

                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}
