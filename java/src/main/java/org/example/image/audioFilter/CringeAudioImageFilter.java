package org.example.image.audioFilter;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor
public class CringeAudioImageFilter extends BaseAudioImageFilter {

    public CringeAudioImageFilter(List<Double> audio) {
        super(audio);
    }

    private int getColor() {
        return audio.get(ThreadLocalRandom.current().nextInt(0, audio.size()));
    }

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var rgb = new RGB(255, bfi.getRGB(x, y));
                rgb.incR(getColor());
                rgb.incG(getColor());
                rgb.incB(getColor());

                var p = getArgbPixel(rgb.getA(), rgb.getR(), rgb.getG(), rgb.getB());
                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}
