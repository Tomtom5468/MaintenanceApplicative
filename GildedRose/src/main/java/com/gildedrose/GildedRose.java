package com.gildedrose;

import static com.gildedrose.AgedBackstage.agebackstage;
import static com.gildedrose.SellIn.sellin;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            agebackstage(items[i]);
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            sellin(items[i]);
        }
    }
}
