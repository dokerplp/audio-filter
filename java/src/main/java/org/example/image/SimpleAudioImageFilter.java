package org.example.image;

import java.util.List;

public class SimpleAudioImageFilter extends BaseAudioImageFilter {

    public SimpleAudioImageFilter(List<Double> audio) {
        super(audio);
    }

    private int getAlpha() {
        if (audio.isEmpty()) return 255;
        return audio.stream().max(Integer::compareTo).get() % 256;
    }

    private int getColor(int c, int audio) {
        return (c + audio) % 256;
    }

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        int pos = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int color = bfi.getRGB(x, y);

                int r = (color & 0xff0000) >> 16;
                int g = (color & 0xff00) >> 8;
                int b = color & 0xff;

                int a = 255;
                r = getColor(r, audio.get(pos++ % audio.size()));
                g = getColor(g, audio.get(pos++ % audio.size()));
                b = getColor(b, audio.get(pos++ % audio.size()));

                var p = getArgbPixel(a, r, g, b);

                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}