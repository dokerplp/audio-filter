package org.example.image.audioFilter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class DuckAudioImageFilter extends BaseAudioImageFilter {

    @Data
    @AllArgsConstructor
    static class XY {
        private int x, y;
    }

    public DuckAudioImageFilter(List<Double> audio) {
        super(audio);
    }

    private XY getCoordinates(int width, int height) {
        return new XY(rand(-width, width), rand(-height, height));
    }

    private int getMaxAudio() {
        return audio.isEmpty() ? 0 : audio.stream().max(Integer::compareTo).get();
    }

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        var duck = openImageFromResources("duck.png");
        var duckWidth = duck.getWidth();
        var duckHeight = duck.getHeight();
        List<XY> ducks = new ArrayList<>();
        for (int i = 0; i < getMaxAudio() / 3; i++) {
            ducks.add(getCoordinates(width, height));
        }

        for (XY xy: ducks) {
            for (int y = xy.getY(), dy = 0; dy < duckHeight && y < height; y++, dy++) {
                for (int x = xy.getX(), dx = 0; dx < duckWidth && x < width; x++, dx++) {
                    if (y >= 0 && x >= 0) {
                        var p = duck.getRGB(dx, dy);
                        if (p != 0) bfi.setRGB(x, y, p);
                    }
                }
            }
        }
        return bufferedImageToString(bfi);
    }
}
