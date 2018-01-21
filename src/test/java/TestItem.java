import basket.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestItem {

    Item apple;

    @Before
    public void before(){
       apple = new Item("Apple", 2.0);
    }

    @Test
    public void getName(){
        assertEquals("Apple", apple.getName());
    }

    @Test
    public void setName() {
        apple.setName("Granny Smith");
        assertEquals("Granny Smith", apple.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(2.0, apple.getPrice(), 0.01);
    }

    @Test
    public void setPrice() {
        apple.setPrice(1.0);
        assertEquals(1.0, apple.getPrice(), 0.01);
    }
}
