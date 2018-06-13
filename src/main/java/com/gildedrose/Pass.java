package com.gildedrose;

public class Pass extends Item {
    public Pass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (sellIn <= 0 ) {
            quality = 0;
        } else if (sellIn <= 5) {
            quality += 3;
        } else if (sellIn < 10) {
            quality += 2;
        } else {
            quality += 1;
        }
        sellIn -= 1;
    }
}
