package org.example.strategy;

import org.example.image.ImageFilter;

import java.util.List;
import java.util.Map;

public class FiltersStrategy {

    public ImageFilter getImageFilter(String name) {
        var f = ImageFilterEnum.getFilter(name);
        return f.orElseGet(ImageFilterEnum.DEFAULT::getFilter);
    }

    public ImageFilter getAudioImageFilter(String name, List<Double> audio) {
        var f = AudioImageFilterEnum.getFilter(name);
        if (f.isPresent()) {
            var filter = f.get();
            filter.setAudio(audio);
            return filter;
        } else return ImageFilterEnum.DEFAULT.getFilter();
    }

    public ImageFilter getFilter(String name, List<Double> audio) {
        var f = ImageFilterEnum.getFilter(name);
        if (f.isPresent()) return f.get();
        var af = AudioImageFilterEnum.getFilter(name);
        if (af.isPresent()) {
            var filter = af.get();
            filter.setAudio(audio);
            return filter;
        }
        return ImageFilterEnum.DEFAULT.getFilter();
    }
}
