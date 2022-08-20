package org.example.image;

public class AbsoluteImageFilter extends BaseImageFilter {


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
                    r = 255;
                } else if (g > r && g > b) {
                    g = 255;
                } else if (b > r && b > g) {
                    b = 255;
                }
                int a = 255;

                var p = getArgbPixel(a, r, g, b);

                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}
