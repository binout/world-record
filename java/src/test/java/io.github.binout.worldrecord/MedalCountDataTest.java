package io.github.binout.worldrecord;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedalCountDataTest {

    @Test
    public void playWithLombok() {
        var medalCount = new MedalCountData(5, 2, 1);
        assertEquals(medalCount.getGold(), 5);
        assertEquals(medalCount.getSilver(), 2);
        assertEquals(medalCount.getBronze(), 1);

        var medalCountFr = new MedalCountData(5, 2, 1);
        var medalCountDe = new MedalCountData(5, 3, 1);
        var medalCountUs = new MedalCountData(15, 2, 1);
        var sortedMedalCount = Stream.of(medalCountUs, medalCountDe, medalCountFr).sorted().toList();
        assertEquals(medalCountFr, sortedMedalCount.get(0));
        assertEquals(medalCountDe, sortedMedalCount.get(1));
        assertEquals(medalCountUs, sortedMedalCount.get(2));

        var total = medalCountFr.add(medalCountDe).add(medalCountUs);
        assertEquals(total, new MedalCountData(25, 7, 3));
    }
}
