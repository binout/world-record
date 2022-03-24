package io.github.binout.worldrecord;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedalCountTest {

    @Test
    public void playWithRecord() {
        var medalCount = new MedalCount(5, 2, 1);
        assertEquals(medalCount.gold(), 5);
        assertEquals(medalCount.silver(), 2);
        assertEquals(medalCount.bronze(), 1);

        assertThrows(IllegalArgumentException.class, () -> {
            new MedalCount(-1, 0, 1);
        });

        var medalCountFr = new MedalCount(5, 2, 1);
        var medalCountDe = new MedalCount(5, 3, 1);
        var medalCountUs = new MedalCount(15, 2, 1);
        var sortedMedalCount = Stream.of(medalCountUs, medalCountDe, medalCountFr).sorted().toList();
        assertEquals(medalCountFr, sortedMedalCount.get(0));
        assertEquals(medalCountDe, sortedMedalCount.get(1));
        assertEquals(medalCountUs, sortedMedalCount.get(2));

        var total = medalCountFr.add(medalCountDe).add(medalCountUs);
        assertEquals(total, new MedalCount(25, 7, 3));
    }
}
