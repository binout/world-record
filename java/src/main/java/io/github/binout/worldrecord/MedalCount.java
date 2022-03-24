package io.github.binout.worldrecord;

import java.util.Comparator;

public record MedalCount(int gold, int silver, int bronze) implements Comparable<MedalCount> {

    public MedalCount {
        if (gold < 0 || silver < 0 || bronze < 0) {
            throw new IllegalArgumentException("Medal count should be positive");
        }
    }

    @Override
    public int compareTo(MedalCount medalCount) {
        return Comparator.comparing(MedalCount::gold)
                .thenComparing(MedalCount::silver)
                .thenComparing(MedalCount::bronze)
                .compare(this, medalCount);
    }

    public MedalCount add(MedalCount medalCount) {
        return new MedalCount(
                gold + medalCount.gold,
                silver + medalCount.silver,
                bronze + medalCount.bronze());
    }
}
