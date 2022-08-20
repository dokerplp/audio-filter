package org.example.image.filter;

public class AbsoluteImageFilter extends BaseImageFilter {


    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var rgb = new RGB(255, bfi.getRGB(x, y));
                if (rgb.getR() > rgb.getG() && rgb.getR() > rgb.getB()) {
                    rgb.setR(255);
                } else if (rgb.getG() > rgb.getR() && rgb.getG() > rgb.getB()) {
                    rgb.setG(255);
                } else if (rgb.getB() > rgb.getR() && rgb.getB() > rgb.getG()) {
                    rgb.setB(255);
                }

                var p = getArgbPixel(rgb.getA(), rgb.getR(), rgb.getG(), rgb.getB());

                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}
