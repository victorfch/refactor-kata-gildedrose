import com.ieslasgalletas.gildedrosekata.GildedRose;
import com.ieslasgalletas.gildedrosekata.Item;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;


public class GildedRoseTest {
    @Ignore
    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }
}
