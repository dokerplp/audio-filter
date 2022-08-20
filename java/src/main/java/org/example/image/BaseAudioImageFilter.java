package org.example.image;

import java.util.List;

public abstract class BaseAudioImageFilter extends BaseImageFilter {
    protected final List<Integer> audio;


    protected BaseAudioImageFilter(List<Double> audio) {
        this.audio = audio.stream().map((o) -> (int) Math.round(o * 500)).toList();
    }
}
