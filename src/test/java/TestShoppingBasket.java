import basket.Basket;
import basket.Item;
import discount.BoGoF;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShoppingBasket {

    Item apple;
    Item gum;
    Basket basket;
    BoGoF boGoF;

    @Before
    public void before(){
        apple = new Item("Apple", 2.00);
        gum = new Item("Gum", 1.00);
        basket = new Basket();
        boGoF = new BoGoF();

    }


    @Test
    public void canGetTotal(){
        basket.addItem(apple);
        basket.addItem(apple);
        basket.addItem(gum);
        assertEquals(5.00, basket.getTotal(), 0.01);
    }

    @Test
    public void BoGoF(){
        basket.addItem(apple);
        basket.addItem(apple);
        basket.addItem(gum);
        basket.addDiscount(boGoF);
        basket.setTotal(boGoF.applyDiscount(basket.getItems(), basket.getTotal()));
        assertEquals(3.00, basket.getTotal(), 0.01);

    }

}
