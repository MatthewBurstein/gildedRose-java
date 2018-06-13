package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    public GildedRose buildRose(Item[] items) {
        GildedRose gr = new GildedRose(items);
        gr.updateQuality();
        return gr;
    }

    @Test
    public void itemQualityIsNotNegative() {
        Item[] items = new Item[] { new Item("Generic Item", -1, 0)};
        GildedRose gr = buildRose(items);
        assertEquals(0, gr.items[0].quality);
    }

    @Test
    public void genericItemQualityWhenInDate_DropsByOne() {
        Item[] items = new Item[] { new Item("Generic Item", 10, 6)};
        GildedRose gr = buildRose(items);
        assertEquals(5, gr.items[0].quality);
    }

    @Test
    public void genericItemQualityWhenOutOfDate_DropsByTwo() {
        Item[] items = new Item[] { new Item("Generic Item", 0, 6)};
        GildedRose gr = buildRose(items);
        assertEquals(4, gr.items[0].quality);
    }

    @Test
    public void agedBrieQualityWhenInDate_IncreasesByOne() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 12) };
        GildedRose gr = buildRose(items);
        assertEquals(13, gr.items[0].quality);
    }

    @Test
    public void agedBrieQualityWhenOutOfDate_IncreasesByTwo() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 12) };
        GildedRose gr = buildRose(items);
        assertEquals(14, gr.items[0].quality);
    }

    @Test
    public void agedBrieQuality_IsNotMoreThanFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 49)};
        GildedRose gr = buildRose(items);
        assertEquals(50, gr.items[0].quality);
    }

    @Test
    public void sulfurasQualityWhenInDate_IsUnchanged() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 3, 49) };
        GildedRose gr = buildRose(items);
        assertEquals(49, gr.items[0].quality);
    }

    @Test
    public void sulfurasQualityWhenOutOfDate_IsUnchanged() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 49) };
        GildedRose gr = buildRose(items);
        assertEquals(49, gr.items[0].quality);
    }

    @Test
    public void sulfurasSellIn_IsUnchanged() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 3, 49) };
        GildedRose gr = buildRose(items);
        assertEquals(3, gr.items[0].sellIn);
    }

    @Test
    public void backstageQualityWhenOutOfDate_isZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 5)};
        GildedRose gr = buildRose(items);
        assertEquals(0, gr.items[0].quality);
    }

    @Test
    public void backstageQualityWhenFiveDaysLeftOrLess_IncreasesByThree() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 25) };
        GildedRose gr = buildRose(items);
        assertEquals(28, gr.items[0].quality);
    }

    @Test
    public void backstageQualityWhenFiveToTenDaysLeft_IncreasesByTwo() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 25) };
        GildedRose gr = buildRose(items);
        assertEquals(27, gr.items[0].quality);
    }

    @Test
    public void backstageQualityOtherwise_IncreasesByOne() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 25) };
        GildedRose gr = buildRose(items);
        assertEquals(26, gr.items[0].quality);
    }

    @Test
    public void conjuredItemQualityWhenInDate_DecreasesByTwo() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose gr = buildRose(items);
        assertEquals(4, gr.items[0].quality);
    }

    @Test
    public void conjuredItemQualityWhenInDate_DecreasesByFour() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 6) };
        GildedRose gr = buildRose(items);
        assertEquals(2, gr.items[0].quality);
    }
}
