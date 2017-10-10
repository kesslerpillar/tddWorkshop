package sample;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class SampleGildedRoseTest {

    private SampleGildedRose sampleGildedRose;

    @Before
    public void setUp() {
        sampleGildedRose = new SampleGildedRose();
    }

    @Test
    public void inventoryContainsSixItems() {
        List<SampleItem> inventory = sampleGildedRose.updateQuality();

        assertEquals(6, inventory.size());
    }

    @Test
    public void reduceSellInForAllItemsExceptSulfuras() {
        List<SampleItem> inventoryBefore = sampleGildedRose.getInventory();

        assertItem(inventoryBefore.get(0), "+5 Dexterity Vest", 10, 20);
        assertItem(inventoryBefore.get(1), "Aged Brie", 2, 0);
        assertItem(inventoryBefore.get(2), "Elixir of the Mongoose", 5, 7);
        assertItem(inventoryBefore.get(3), "Sulfuras, Hand of Ragnaros", 0, 80);
        assertItem(inventoryBefore.get(4), "Backstage passes to a TAFKAL80ETC concert", 15, 20);
        assertItem(inventoryBefore.get(5), "Conjured Mana Cake", 3, 6);

        List<SampleItem> inventory = sampleGildedRose.updateQuality();

        assertItem(inventoryBefore.get(3), "Sulfuras, Hand of Ragnaros", 0, 80);

        assertItem(inventoryBefore.get(0), "+5 Dexterity Vest", 9, 20);
        assertItem(inventoryBefore.get(1), "Aged Brie", 1, 0);
        assertItem(inventoryBefore.get(2), "Elixir of the Mongoose", 4, 7);
        assertItem(inventoryBefore.get(4), "Backstage passes to a TAFKAL80ETC concert", 14, 20);
        assertItem(inventoryBefore.get(5), "Conjured Mana Cake", 2, 6);

        assertEquals(6, inventory.size());
    }

    private void assertItem(SampleItem item, String expectedName, int expectedSellIn, int expectedQuality) {
        assertEquals(expectedName, item.getName());
        assertEquals(expectedSellIn, item.getSellIn());
        assertEquals(expectedQuality, item.getQuality());
    }
}