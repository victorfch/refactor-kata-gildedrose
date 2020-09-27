import com.ieslasgalletas.gildedrosekata.GildedRose;
import com.ieslasgalletas.gildedrosekata.Item;
import org.junit.Test;
import static org.junit.Assert.*;


public class GildedRoseTest {
    
    @Test
    public void AgedBrieShoudIncreaseQualityNormal() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie, 1, 1", app.items[0].toString());
    }
    
    @Test
    public void AgedBrieShoudIncreaseQualityByTwoEachDay() {
        int sellIn = 0;
        int quality = 2;
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        int days = 2;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
            sellIn--;
            quality += 2;
            assertEquals("Aged Brie, " + sellIn + ", " + quality, app.items[0].toString());
        }
    }
    
    @Test
    public void AgedBrieQualityShouldntBeMoreThanFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie, 1, 50", app.items[0].toString());
    }
    
    @Test
    public void SulfurasShouldntChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 80) };
        GildedRose app = new GildedRose(items);
        int days = 3;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
            assertEquals("Sulfuras, Hand of Ragnaros, 2, 80", app.items[0].toString());            
        }
    }
    
    @Test
    public void BackstagePassQualityShouldIncreaseNormalIfSellInIsMoreThanTen() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 14, 21", app.items[0].toString());
    }
    
    @Test
    public void BackstagePassQualityShouldIncreaseByTwoIfSellInIsBetweenTenAndFive() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 8, 22", app.items[0].toString());
    }
    
    public void BackstagePassQualityShouldIncreaseByThreeIfSellInIsBetweenFiveAndZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 3, 18", app.items[0].toString());
    }
    
    public void BackstagePassQualityShouldBeZeroIfSellInIsLessThanZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", app.items[0].toString());
    }
    
    public void BackstagePassQualityShouldntBeMoreThanThirty() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 2, 30", app.items[0].toString());
    }
}
