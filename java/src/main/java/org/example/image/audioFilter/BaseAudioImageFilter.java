package org.example.image.audioFilter;

import org.example.image.filter.BaseImageFilter;

import java.util.List;

public abstract class BaseAudioImageFilter extends BaseImageFilter {
    protected final List<Integer> audio;


    protected BaseAudioImageFilter(List<Double> audio) {
        this.audio = audio.stream().map((o) -> (int) Math.round(o * 1000)).toList();
    }
}
