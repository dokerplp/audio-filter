package org.example.strategy;

import lombok.Getter;
import org.example.image.audioFilter.*;

import java.util.EnumSet;
import java.util.Optional;

public enum AudioImageFilterEnum {
    CRINGE_AUDIO(new CringeAudioImageFilter()),
    DRUG_AUDIO(new DrugAudioImageFilter()),
    FLOAT_AUDIO(new FloatAudioImageFilter()),
    WHITE_NOISE_AUDIO(new WhiteNoiseAudioImageFilter()),
    LINE_AUDIO(new LineAudioImageFilter()),
    BLOAT_AUDIO(new BloatAudioImageFilter());

    private final static EnumSet<AudioImageFilterEnum> filters = EnumSet.allOf(AudioImageFilterEnum.class);
    @Getter
    private final BaseAudioImageFilter filter;

    AudioImageFilterEnum(BaseAudioImageFilter filter) {
        this.filter = filter;
    }

    public static Optional<BaseAudioImageFilter> getFilter(String name) {
        var f = filters.stream().filter(o -> o.toString().equals(name)).findAny();
        return f.map(o -> o.filter);
    }
}
