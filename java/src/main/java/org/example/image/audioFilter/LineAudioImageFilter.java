package org.example.image.audioFilter;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class LineAudioImageFilter extends BaseAudioImageFilter {

    public LineAudioImageFilter(List<Double> audio) {
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
                var newY = (y + Math.abs(audio.get(i))) % height;
                var p = bfi.getRGB(x, newY);
                copy.setRGB(x, y, p);
            }
            i++;
            i %= audio.size();
        }
        return bufferedImageToString(copy);
    }
}
