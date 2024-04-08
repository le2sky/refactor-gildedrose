package com.gildedrose;

import java.util.Arrays;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        String[] name = {
                "foo",
                "Aged Brie",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert"
        };
        Integer[] sellIn = {-1, 0, 1, 6, 11};
        Integer[] quality = {0, 1, 49, 50};

        CombinationApprovals.verifyAllCombinations(this::doUpdateQuality, name, sellIn, quality);
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{
                new Item(name, sellIn, quality)
        };
        GildedRose sut = new GildedRose(items);
        sut.updateQuality();

        return Arrays.asList(sut.items).toString();
    }
}
