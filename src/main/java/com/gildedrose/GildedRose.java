package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Categorizer c = new Categorizer();
        int bound = items.length;
        for (int i = 0; i < bound; i++) {
            ItemInterface itemObj = c.categorize(items[i]);
            itemObj.updateQuality();
            items[i] = (Item) itemObj;
        }
    }

    private class Categorizer {

        public ItemInterface categorize(Item item) {
            ItemInterface itemObj = null;
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                itemObj = new Legendary(item.name, item.sellIn, item.quality);
            } else if (item.name.equals("Aged Brie")) {
                itemObj = new Brie(item.name, item.sellIn, item.quality);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                itemObj = new Pass(item.name, item.sellIn, item.quality);
            } else if (item.name.equals("Conjured Mana Cake")) {
                itemObj = new ConjuredItem(item.name, item.sellIn, item.quality);
            } else {
                itemObj = new GenericItem(item.name, item.sellIn, item.quality);
            }
            return itemObj;
        }
    }
}