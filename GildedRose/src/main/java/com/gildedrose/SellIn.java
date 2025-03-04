package com.gildedrose;

public class SellIn {
    static void sellin(Item items){
        if (items.sellIn < 0) {
            if (!items.name.equals("Aged Brie")) {
                if (!items.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (items.quality > 0) {
                        if (!items.name.equals("Sulfuras, Hand of Ragnaros")) {
                            items.quality = items.quality - 1;
                        }
                    }
                } else {
                    items.quality = items.quality - items.quality;
                }
            } else {
                if (items.quality < 50) {
                    items.quality = items.quality + 1;
                }
            }
        }
    }

}
