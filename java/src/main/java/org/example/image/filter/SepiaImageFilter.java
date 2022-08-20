package org.example.image.filter;

public class SepiaImageFilter extends BaseImageFilter {

    private int red(int r, int g, int b) {
        return Math.min((int)((r * .393) + (g *.769) + (b * .189)), 255);
    }

    private int green(int r, int g, int b) {
        return Math.min((int)((r * .349) + (g *.686) + (b * .168)), 255);
    }

    private int blue(int r, int g, int b) {
        return Math.min((int)((r * .272) + (g *.534) + (b * .131)), 255);
    }

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var rgb = new RGB(255, bfi.getRGB(x, y));
                int r = red(rgb.getR(), rgb.getG(), rgb.getB());
                int g = green(rgb.getR(), rgb.getG(), rgb.getB());
                int b = blue(rgb.getR(), rgb.getG(), rgb.getB());
                rgb.setR(r);
                rgb.setG(g);
                rgb.setB(b);

                var p = getArgbPixel(rgb.getA(), rgb.getR(), rgb.getG(), rgb.getB());
                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}
