package com.gildedrose;

public class Legendary extends Item implements ItemInterface {
    public Legendary(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
    }
}
