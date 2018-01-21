import basket.Basket;
import basket.Item;
import discount.BoGoF;
import discount.LoyaltyCard;
import discount.PercentageDiscount;
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
    PercentageDiscount tenPercent;
    PercentageDiscount twentyPercent;
    LoyaltyCard loyaltyCard;
    LoyaltyCard staffCard;

    @Before
    public void before(){
        apple = new Item("Apple", 2.00);
        gum = new Item("Gum", 1.00);
        dvd = new Item("DVD", 20.00);
        cd = new Item("CD", 3.00);
        basket = new Basket();
        boGoF = new BoGoF();
        tenPercent = new PercentageDiscount(20.00, 0.9);
        twentyPercent = new PercentageDiscount(30.00, 0.8);
        loyaltyCard = new LoyaltyCard(0.98);
        staffCard = new LoyaltyCard(0.96);

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
    public void canApplyPercentageDiscount(){
        basket.addItem(dvd);
        basket.addDiscount(tenPercent);
        basket.applyDiscounts();
        assertEquals(18.00, basket.getTotal(), 0.01);
        assertEquals(20.00, basket.priceBeforeDiscount(), 0.01);
    }

    @Test
    public void canUseDifferentPercentageDiscounts(){
        basket.addItem(dvd);
        basket.addItem(dvd);
        basket.addDiscount(twentyPercent);
        basket.applyDiscounts();
        assertEquals(32.00, basket.getTotal(), 0.01);
        assertEquals(40.00, basket.priceBeforeDiscount(), 0.01);
    }

    @Test
    public void percentageDiscountNotAppliedIfBelowTotalNeeded(){
        basket.addItem(cd);
        basket.addItem(cd);
        basket.addItem(cd);
        basket.addDiscount(tenPercent);
        basket.applyDiscounts();
        assertEquals(9.00, basket.getTotal(), 0.01);

    }


    @Test
    public void canApplyBoGoFandPercentageDiscounts(){
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
    public void canUseDifferentLoyaltyCards(){
        basket.addItem(dvd);
        basket.addDiscount(staffCard);
        basket.applyDiscounts();
        assertEquals(19.20, basket.getTotal(), 0.01);
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
    public void canRemoveItem(){
        basket.addItem(apple);
        basket.addItem(apple);
        assertEquals(2, basket.getItems().size());
        basket.removeItem(apple);
        assertEquals(1, basket.getItems().size());
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
