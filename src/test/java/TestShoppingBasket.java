import basket.Basket;
import basket.Item;
import discount.BoGoF;
import discount.LoyaltyCard;
import discount.TenPercent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShoppingBasket {

    Item apple;
    Item gum;
    Item dvd;
    Item cd;
    Basket basket;
    BoGoF boGoF;
    TenPercent tenPercent;
    LoyaltyCard loyaltyCard;

    @Before
    public void before(){
        apple = new Item("Apple", 2.00);
        gum = new Item("Gum", 1.00);
        dvd = new Item("DVD", 20.00);
        cd = new Item("CD", 3.00);
        basket = new Basket();
        boGoF = new BoGoF();
        tenPercent = new TenPercent(20.00, 0.9);
        loyaltyCard = new LoyaltyCard(0.98);

    }



    @Test
    public void canAddItems(){
        basket.addItem(apple);
        basket.addItem(gum);
        assertEquals(2, basket.getItems().size());
    }

    @Test
    public void canAddDiscounts(){
        basket.addDiscount(boGoF);
        basket.addDiscount(tenPercent);
        assertEquals(2, basket.getDiscounts().size());
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
        assertEquals(5.00, basket.priceBeforeDiscount(), 0.01);

    }

    @Test
    public void BoGoF2Items(){
        basket.addItem(apple);
        basket.addItem(apple);
        basket.addItem(gum);
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
        assertEquals(20.00, basket.priceBeforeDiscount(), 0.01);
    }

    @Test
    public void tenPercentNotAppliedIfBelowTotalNeeded(){
        basket.addItem(cd);
        basket.addItem(cd);
        basket.addItem(cd);
        basket.addDiscount(tenPercent);
        basket.applyDiscounts();
        assertEquals(9.00, basket.getTotal(), 0.01);

    }


    @Test
    public void canApplyBoGoFandTenPercent(){
        basket.addItem(apple);
        basket.addItem(apple);
        basket.addItem(dvd);
        basket.addDiscount(boGoF);
        basket.addDiscount(tenPercent);
        basket.applyDiscounts();
        assertEquals(19.80, basket.getTotal(), 0.01);
        assertEquals(24.00, basket.priceBeforeDiscount(), 0.01);
    }


    @Test
    public void canUseLoyaltyCard(){
        basket.addItem(dvd);
        basket.addDiscount(loyaltyCard);
        basket.applyDiscounts();
        assertEquals(19.60, basket.getTotal(), 0.01);
    }

    @Test
    public void canUseAllDiscounts(){
        basket.addItem(apple);
        basket.addItem(apple);
        basket.addItem(dvd);
        basket.addItem(cd);
        basket.addDiscount(boGoF);
        basket.addDiscount(tenPercent);
        basket.addDiscount(loyaltyCard);
        basket.applyDiscounts();
        assertEquals(22.05, basket.getTotal(), 0.01);
    }


    @Test
    public void canEmptyBasket(){
        basket.addItem(apple);
        assertEquals(1, basket.getItems().size());
        assertEquals(2.00, basket.getTotal(), 0.01);
        basket.emptyBasket();
        assertEquals(0, basket.getItems().size());
        assertEquals(0.0, basket.getTotal(), 0.01);

    }




}
