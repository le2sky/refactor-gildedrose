package com.gildedrose;

class Backstage extends Item {

    public Backstage(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    void updateQualityFor() {
        switch (name) {
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (quality < 50) {
                    quality = quality + 1;

                    if (sellIn < 11 && quality < 50) {
                        quality = quality + 1;
                    }

                    if (sellIn < 6 && quality < 50) {
                        quality = quality + 1;
                    }
                }

                sellIn = sellIn - 1;

                if (sellIn < 0) {
                    quality = 0;
                }
                break;
            case "Aged Brie":
                if (quality < 50) {
                    quality = quality + 1;
                }

                sellIn = sellIn - 1;

                if (sellIn < 0 && quality < 50) {
                    quality = quality + 1;
                }
                break;
            default:
                if (quality > 0) {
                    quality = quality - 1;
                }

                sellIn = sellIn - 1;

                if (sellIn < 0 && quality > 0) {
                    quality = quality - 1;
                }
                break;
        }
    }
}
