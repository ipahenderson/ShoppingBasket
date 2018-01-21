package discount;

import basket.Item;

import java.util.ArrayList;

public class LoyaltyCard implements IDiscount {

    double modifier;

    public LoyaltyCard(double modifier) {
        this. modifier = modifier;
    }

    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {
        total *= modifier;
        return total;
    }
}
