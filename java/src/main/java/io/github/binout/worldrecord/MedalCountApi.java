package io.github.binout.worldrecord;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class MedalCountApi {

    public HashMap<MedalCount, List<String>> getMedalCountPerCountry() {
        var medalCountPerCountry = new HashMap<MedalCount, List<String>>();
        medalCountPerCountry.put(
                new MedalCount(5, 2, 1), asList("us", "cn"));
        medalCountPerCountry.put(
                new MedalCount(1, 1, 1), asList("fr", "de"));
        return medalCountPerCountry;
    }

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
