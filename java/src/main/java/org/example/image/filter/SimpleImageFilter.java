package org.example.image.filter;

import java.awt.image.BufferedImage;

public class SimpleImageFilter extends BaseImageFilter {
    @Override
    public String filter(String image) {
        BufferedImage img = stringToBufferedImage(image);
        return bufferedImageToString(img);
    }
}
