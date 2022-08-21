package org.example.image.audioFilter;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.image.filter.BaseImageFilter;

import java.util.List;

@NoArgsConstructor
public abstract class BaseAudioImageFilter extends BaseImageFilter {

    protected List<Integer> audio;

    protected BaseAudioImageFilter(List<Double> audio) {
        setAudio(audio);
    }

    public void setAudio(List<Double> audio) {
        this.audio = audio.stream().map((o) -> (int) Math.round(o * 1000)).toList();
    }
}
