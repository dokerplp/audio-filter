package org.example.image.filter;

public class WhiteNoise2ImageFilter extends BaseImageFilter {

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();


        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var rgb = new RGB(225, bfi.getRGB(x, y));
                int rand = rand(0, 3);

                if (rand == 0) {
                    rgb.setR(rand(0, 256));
                    rgb.setG(rand(0, 256));
                }
                if (rand == 1) {
                    rgb.setR(rand(0, 256));
                    rgb.setB(rand(0, 256));
                }
                if (rand == 2) {
                    rgb.setG(rand(0, 256));
                    rgb.setB(rand(0, 256));
                }

                var p = getArgbPixel(rgb.getA(), rgb.getR(), rgb.getG(), rgb.getB());
                bfi.setRGB(x, y, p);
            }
        }
        return bufferedImageToString(bfi);
    }
}
