package org.example.image.filter;

public class PurpleNegativeImageFilter extends BaseImageFilter {
    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var rgb = new BaseImageFilter.RGB(255, bfi.getRGB(x, y));
                rgb.setR(255 - rgb.getR());
                rgb.setG(255 - rgb.getG());
                rgb.setB(255 - rgb.getB());

                var p = getArgbPixel(rgb.getA(), rgb.getG(), rgb.getR(), rgb.getB());
                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}
