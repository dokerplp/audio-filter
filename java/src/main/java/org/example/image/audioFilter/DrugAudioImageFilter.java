package org.example.image.audioFilter;

import java.util.List;

public class DrugAudioImageFilter extends BaseAudioImageFilter {

    public DrugAudioImageFilter(List<Double> audio) {
        super(audio);
    }

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        int i = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int color = bfi.getRGB(x, y);

                int r = (color & 0xff0000) >> 16;
                int g = (color & 0xff00) >> 8;
                int b = color & 0xff;

                r += Math.abs(audio.get(i++ % audio.size()));
                g += Math.abs(audio.get(i++ % audio.size())) * 2;
                b += Math.abs(audio.get(i++ % audio.size())) * 3;

                r %= 256;
                g %= 256;
                b %= 256;


                int a = 255;
                var p = getArgbPixel(a, r, g, b);

                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}
