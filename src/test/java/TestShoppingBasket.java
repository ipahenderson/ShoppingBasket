import basket.Basket;
import basket.Item;
import discount.BoGoF;
import discount.TenPercent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShoppingBasket {

    Item apple;
    Item gum;
    Item dvd;
    Basket basket;
    BoGoF boGoF;
    TenPercent tenPercent;

    @Before
    public void before(){
        apple = new Item("Apple", 2.00);
        gum = new Item("Gum", 1.00);
        dvd = new Item("Gum", 20.00);
        basket = new Basket();
        boGoF = new BoGoF();
        tenPercent = new TenPercent();

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
        basket.applyDiscounts();
        assertEquals(3.00, basket.getTotal(), 0.01);

    }

    @Test
    public void tenPercentOffTwenty(){
        basket.addItem(dvd);
        basket.addDiscount(tenPercent);
        basket.applyDiscounts();
        assertEquals(18.00, basket.getTotal(), 0.01);
    }

}
