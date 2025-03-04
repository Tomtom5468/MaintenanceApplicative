package com.gildedrose;

public class AgedBackstage {
    static void agebackstage(Item items){
        if (!items.name.equals("Aged Brie")
                && !items.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items.quality > 0) {
                if (!items.name.equals("Sulfuras, Hand of Ragnaros")) {
                    items.quality = items.quality - 1;
                }
            }
        } else {
            if (items.quality < 50) {
                items.quality = items.quality + 1;

                if (items.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (items.sellIn < 11) {
                        if (items.quality < 50) {
                            items.quality = items.quality + 1;
                        }
                    }

                    if (items.sellIn < 6) {
                        if (items.quality < 50) {
                            items.quality = items.quality + 1;
                        }
                    }
                }
            }
        }
    }
}
