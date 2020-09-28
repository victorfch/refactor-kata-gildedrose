package com.ieslasgalletas.gildedrosekata;

public class GildedRose {

    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void increaseQuality(int item) {
        items[item].quality++;
    }

    public void decreaseQuality(int item) {
        items[item].quality--;
    }

    public void decreaseSellIn(int item) {
        items[item].sellIn--;
    }
    
    public void decreaseQualityToZero(int item) {
        items[item].quality = 0;
    }
    
    public boolean canIncreaseQuality(int item) {
        return items[item].quality < 50;
    }

    public boolean isQualityPositive(int item) {
        return items[item].quality > 0;
    }
    
    public boolean isSellInNegative(int item) {
        return items[item].sellIn < 0;
    }

    public boolean isSulfuras(int item) {
        return items[item].name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean isAgedBrie(int item) {
        return items[item].name.equals("Aged Brie");
    }

    public boolean isBackstagePasses(int item) {
        return items[item].name.equals("Backstage passes to a TAFKAL80ETC concert");
    }
    
    public boolean isNormalItem(int item) {
        return !isAgedBrie(item) && !isBackstagePasses(item) && !isSulfuras(item);
    }

    public void updateQuality() {
        for (int item = 0; item < items.length; item++) {
            if (!isAgedBrie(item) && !isBackstagePasses(item)) {
                if (isQualityPositive(item) && !isSulfuras(item)) {
                    decreaseQuality(item);
                }
            } else if (canIncreaseQuality(item)) {
                increaseQuality(item);
                if (isBackstagePasses(item)) {
                    if (items[item].sellIn < 11 && canIncreaseQuality(item)) {
                        increaseQuality(item);
                    }
                    if (items[item].sellIn < 6 && canIncreaseQuality(item)) {
                        increaseQuality(item);
                    }
                }
            }

            if (!isSulfuras(item)) {
                decreaseSellIn(item);
            }

            if (isSellInNegative(item)) {
                if (isAgedBrie(item) && canIncreaseQuality(item)) {
                    increaseQuality(item);
                } else if (isNormalItem(item) && isQualityPositive(item)) {
                    decreaseQuality(item);
                } else {
                    decreaseQualityToZero(item);
                }

            }
        }
    }
}
