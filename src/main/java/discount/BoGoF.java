package discount;

import basket.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class BoGoF implements IDiscount{
    public BoGoF() {
    }

    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {
        ArrayList<Item> bogofCheck = new ArrayList<>();
        int bogofCount = 0;
        for (Item item : items){
            if(!bogofCheck.contains(item)){
                bogofCheck.add(item);
            }
        }
        for (Item item : bogofCheck){
            for (Item itemComp : items){
                if (item.equals(itemComp)){
                    bogofCount += 1;
                }
                if (bogofCount == 2){
                    total -= itemComp.getPrice();
                    bogofCount = 0;
                }
            }
            bogofCount = 0;
        }
        return total;

    }
}
    
