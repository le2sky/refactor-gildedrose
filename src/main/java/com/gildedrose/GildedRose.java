package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityFor(item);
        }
    }

    private void updateQualityFor(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < 11 && item.quality < 50) {
                        item.quality = item.quality + 1;
                    }

                    if (item.sellIn < 6 && item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
                break;
            case "Aged Brie":
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0 && item.quality < 50) {
                    item.quality = item.quality + 1;
                }
                break;
            default:
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0 && item.quality > 0) {
                    item.quality = item.quality - 1;
                }
                break;
        }
    }
}
