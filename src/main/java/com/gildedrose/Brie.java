package com.gildedrose;

public class Brie extends Item {
    public Brie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        quality += sellIn >= 0 ? 1 : 2;
        sellIn -= 1;
        if (quality > 50) {
            quality = 50;
        }
    }
}
