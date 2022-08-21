package org.example.image.audioFilter;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
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
                var rgb = new RGB(255, bfi.getRGB(x, y));

                rgb.incR(i);
                i += 10 * Math.abs(audio.get(Math.abs(i % audio.size())));
                rgb.incG(i);
                i += 20 * Math.abs(audio.get(Math.abs(i % audio.size())));
                rgb.incB(i);
                i += 30 * Math.abs(audio.get(Math.abs(i % audio.size())));


                var p = getArgbPixel(rgb.getA(), rgb.getR(), rgb.getG(), rgb.getB());
                bfi.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(bfi);
    }
}
