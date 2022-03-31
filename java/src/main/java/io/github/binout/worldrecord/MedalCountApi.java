package io.github.binout.worldrecord;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class MedalCountApi {

    public MedalCount getMedalCount(String country) {
        return new MedalCount(1, 2, 3);
    }

    public List<String> sortCountryByMedal(List<String> countries) {

        record Data(String country, MedalCount medalCount){}

        return countries.stream()
                .map(country -> new Data(country, getMedalCount(country)))
                .sorted(Comparator.comparing(d -> d.medalCount))
                .map(Data::country)
                .collect(toList());
    }
}
