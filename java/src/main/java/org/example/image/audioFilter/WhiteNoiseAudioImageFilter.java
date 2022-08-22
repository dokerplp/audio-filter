package org.example.image.audioFilter;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class WhiteNoiseAudioImageFilter extends BaseAudioImageFilter {

    public WhiteNoiseAudioImageFilter(List<Double> audio) {
        super(audio);
    }


    private int position(int i) {
        return rand(0, Math.abs(audio.get(i)) + 1) % 256;
    }

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        int i = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var rgb = new RGB(255, bfi.getRGB(x, y));

                int rand = rand(0, 3);

                if (rand == 0) {
                    rgb.setR(position(i));
                }
                if (rand == 1) {
                    rgb.setG(position(i));
                }
                if (rand == 2) {
                    rgb.setB(position(i));
                }

                i += rand(0, 20);
                i %= audio.size();

                var p = getArgbPixel(rgb.getA(), rgb.getR(), rgb.getG(), rgb.getB());
                bfi.setRGB(x, y, p);
            }
        }
        return bufferedImageToString(bfi);
    }
}
