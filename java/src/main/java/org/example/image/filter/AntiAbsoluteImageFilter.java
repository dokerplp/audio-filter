package org.example.image.filter;

public class AntiAbsoluteImageFilter extends BaseImageFilter {

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int color = bfi.getRGB(x, y);

                int r = (color & 0xff0000) >> 16;
                int g = (color & 0xff00) >> 8;
                int b = color & 0xff;
                if (r > g && r > b) {
                    g = 0;
                    b = 0;
                } else if (g > r && g > b) {
                    r = 0;
                    b = 0;
                } else if (b > r && b > g) {
                    r = 0;
                    g = 0;
                }
                int a = 255;

                var p = getArgbPixel(a, r, g, b);

                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}