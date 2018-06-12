package com.gildedrose;

public class Item implements ItemInterface {

    public String name;

    public int sellIn;

    public int quality;

    public Item (String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {};

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
