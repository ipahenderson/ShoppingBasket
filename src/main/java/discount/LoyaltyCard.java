package discount;

import basket.Item;

import java.util.ArrayList;

public class LoyaltyCard implements IDiscount {
    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {
        total *= 0.98;
        return total;
    }
}
