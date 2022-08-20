package org.example.image.filter;

public class RedImageFilter extends BaseImageFilter {
    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int color = bfi.getRGB(x, y);

                int r = (color & 0xff0000) >> 16;
                int g = 0;
                int b = 0;
                int a = 255;

                var p = getArgbPixel(a, r, g, b);

                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}
