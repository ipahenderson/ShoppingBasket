import basket.Basket;
import basket.Item;
import discount.BoGoF;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShoppingBasket {

    Item item1;
    Basket basket;
    BoGoF boGoF;

    @Before
    public void before(){
        item1 = new Item("Apple", 2.00);
        basket = new Basket();
        basket.updateTotal();
        boGoF = new BoGoF();

    }

    @Test
    public void BoGoF(){
        basket.addItem(item1);
        basket.addItem(item1);
        basket.updateTotal();
        basket.addDiscount(boGoF);
        basket.applyDiscounts();
        assertEquals(2.00, basket.getTotal(), 0.01);

    }

}
