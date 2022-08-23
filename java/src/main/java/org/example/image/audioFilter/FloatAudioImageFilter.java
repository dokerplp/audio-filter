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
                var newX = (x + Math.abs(audio.get(i))) % width;
                var newY = (y + Math.abs(audio.get(i))) % height;
                var p = bfi.getRGB(newX, newY);
                i++;
                i %= audio.size();
                copy.setRGB(x, y, p);
            }
        }
        return bufferedImageToString(copy);
    }
}
