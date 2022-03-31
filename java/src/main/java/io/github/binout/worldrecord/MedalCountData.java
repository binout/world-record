package io.github.binout.worldrecord;

import lombok.Data;

import java.util.Comparator;

@Data
public class MedalCountData implements Comparable<MedalCountData> {
    private final int gold;
    private final int silver;
    private final int bronze;

    @Override
    public int compareTo(MedalCountData medalCount) {
        return Comparator.comparing(MedalCountData::getGold)
                .thenComparing(MedalCountData::getSilver)
                .thenComparing(MedalCountData::getBronze)
                .compare(this, medalCount);
    }

    public MedalCountData add(MedalCountData medalCountData) {
        return new MedalCountData(
                gold + medalCountData.getGold(),
                silver + medalCountData.getSilver(),
                bronze + medalCountData.getBronze());
    }
}
