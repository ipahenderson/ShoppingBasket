package discount;

import basket.Item;

import java.util.ArrayList;

public class TenPercent implements IDiscount{

    double modifier;
    double totalneeded;

    public TenPercent(double totalneeded, double modifier) {
        this.totalneeded = totalneeded;
        this.modifier = modifier;
    }

    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {
        if (total >= totalneeded){
            total *= modifier;
        }
        return total;
    }
}
