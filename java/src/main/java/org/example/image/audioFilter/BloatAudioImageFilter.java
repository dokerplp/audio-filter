package org.example.image.audioFilter;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class BloatAudioImageFilter extends BaseAudioImageFilter {

    public BloatAudioImageFilter(List<Double> audio) {
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
                int newX = x;
                int newY = y;
                if (x > width / 2) {
                    newX = Math.max(0, x - Math.abs(audio.get(i)) / 3);
                }
                if (x <= width / 2) {
                    newX = Math.min(width - 1, x + Math.abs(audio.get(i)) / 3);
                }
                if (y >= height / 2) {
                    newY = Math.max(0, y - Math.abs(audio.get(i)) / 3);
                }
                if (y < height / 2) {
                    newY = Math.min(height - 1, y + Math.abs(audio.get(i)) / 3);
                }
                i++;
                i %= audio.size();
                int p = bfi.getRGB(newX, newY);
                copy.setRGB(x, y, p);
            }
        }
        return bufferedImageToString(copy);
    }
}
