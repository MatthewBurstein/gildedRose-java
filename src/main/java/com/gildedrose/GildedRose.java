package com.gildedrose;

import com.sun.javafx.charts.Legend;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Categorizer c = new Categorizer();
        for (int i = 0; i < items.length; i++) {
            ItemInterface itemObj = c.categorize(items[i]);
            itemObj.updateQuality();
            items[i] = (Item) itemObj;
        }
    }

    private class Categorizer {

        public ItemInterface categorize(Item item) {
            ItemInterface itemObj = null;
            if (item.name.startsWith("Sul")) {
                itemObj = new Legendary(item.name, item.sellIn, item.quality);
            } else if (item.name.startsWith("Age")) {
                itemObj = new Brie(item.name, item.sellIn, item.quality);
            } else if (item.name.startsWith("Bac")) {
                itemObj = new Pass(item.name, item.sellIn, item.quality);
            } else {
                itemObj = new GenericItem(item.name, item.sellIn, item.quality);
            }
            return itemObj;
        }
    }
}