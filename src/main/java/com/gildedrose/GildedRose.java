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
            Item itemObj = c.categorize(items[i]);
            itemObj.updateQuality();
            items[i] = (Item) itemObj;
        }
    }

    private class Categorizer {

        public Item categorize(Item item) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return new Legendary(item.name, item.sellIn, item.quality);
            } else if (item.name.equals("Aged Brie")) {
                return new Brie(item.name, item.sellIn, item.quality);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                return new Pass(item.name, item.sellIn, item.quality);
            } else if (item.name.equals("Conjured Mana Cake")) {
                return new ConjuredItem(item.name, item.sellIn, item.quality);
            } else {
                return new GenericItem(item.name, item.sellIn, item.quality);
            }
        }
    }
}