package org.example.strategy;

import lombok.Getter;
import org.example.image.filter.*;

import java.util.EnumSet;
import java.util.Optional;

public enum ImageFilterEnum {
    ABSOLUTE(new AbsoluteImageFilter()),
    ANTI_ABSOLUTE(new AntiAbsoluteImageFilter()),
    BLACK_AND_WHITE(new BlackAndWhiteImageFilter()),
    BLACK_NEGATIVE(new BlackNegativeImageFilter()),
    DEFAULT(new DefaultImageFilter()),
    DRUG(new DrugImageFilter()),
    GREEN_NEGATIVE(new GreenNegativeImageFilter()),
    NEGATIVE(new NegativeImageFilter()),
    ONLY_RED(new OnlyRedImageFilter()),
    PURPLE_NEGATIVE(new PurpleNegativeImageFilter()),
    RED(new RedImageFilter()),
    SEPIA(new SepiaImageFilter()),
    WHITE_NOISE_2(new WhiteNoise2ImageFilter()),
    WHITE_NOISE(new WhiteNoiseImageFilter()),
    PUZZLE(new PuzzleImageFilter());

    private final static EnumSet<ImageFilterEnum> filters = EnumSet.allOf(ImageFilterEnum.class);
    @Getter
    private final BaseImageFilter filter;

    ImageFilterEnum(BaseImageFilter filter) {
        this.filter = filter;
    }

    public static Optional<BaseImageFilter> getFilter(String name) {
        var f = filters.stream().filter(o -> o.toString().equals(name)).findAny();
        return f.map(o -> o.filter);
    }
}
