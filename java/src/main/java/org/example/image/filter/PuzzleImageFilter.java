package org.example.image.filter;

import java.util.*;

public class PuzzleImageFilter extends BaseImageFilter {

    private List<Integer> getDelimiters(int val) {
        Set<Integer> set = new HashSet<>();
        int i = 2;
        while (val != 1) {
            if (val % i == 0) {
                while (val % i == 0) val /= i;
                set.add(i);
            }
            i++;
        }
        return new ArrayList<>(set);
    }

    private int getBlockSize(int val) {
        var list = getDelimiters(val);
        var r = rand(0, list.size() - 1);
        return val / list.get(r);
    }

    private List<Integer> shuffleBlocks(int blocks) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < blocks; i++) list.add(i);
        Collections.shuffle(list);
        return list;
    }

    @Override
    public String filter(String image) {
        var bfi = stringToBufferedImage(image);
        var width = bfi.getWidth();
        var height = bfi.getHeight();

        var widthBlockSize = getBlockSize(width);
        var heightBlockSize = getBlockSize(height);

        var widthBlockCount = width / widthBlockSize;
        var heightBlockCount = height / heightBlockSize;

        var list = shuffleBlocks(widthBlockCount * heightBlockCount);

        var copy = stringToBufferedImage(image);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int block = (y / heightBlockSize) * widthBlockCount + (x / widthBlockSize);

                int randBlock = list.get(block);

                int rx = (randBlock % widthBlockCount) * widthBlockSize + x % widthBlockSize;
                int ry = (randBlock / widthBlockCount) * heightBlockSize + y % heightBlockSize;

                var p = bfi.getRGB(rx, ry);
                copy.setRGB(x, y, p);
            }
        }

        return bufferedImageToString(copy);
    }
}
