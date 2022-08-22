package org.example.image.audioFilter;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class FloatAudioImageFilter extends BaseAudioImageFilter {

    public FloatAudioImageFilter(List<Double> audio) {
        super(audio);
    }

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        var copy = stringToBufferedImage(image);
        int i = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var p = bfi.getRGB((x + Math.abs(audio.get(i))) % width, (y + Math.abs(audio.get(i))) % height);
                i++;
                i %= audio.size();
                copy.setRGB(x, y, p);
            }
        }
        return bufferedImageToString(copy);
    }
}