package org.example.image.filter;

public class OnlyRedImageFilter extends BaseImageFilter {
    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var rgb = new RGB(255, bfi.getRGB(x, y));
                if (rgb.getR() > 1.8 * rgb.getG() && rgb.getR() > 1.8 * rgb.getB()) {
                    rgb.setB(0);
                    rgb.setG(0);
                } else {
                    rgb.setB(rgb.getR());
                    rgb.setG(rgb.getR());
                }

                var p = getArgbPixel(rgb.getA(), rgb.getR(), rgb.getG(), rgb.getB());
                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}
