package discount;

import basket.Item;

import java.util.ArrayList;

public class BoGoF implements IDiscount{
    public BoGoF() {
    }

    @Override
    public void applyDiscount(ArrayList<Item> items, double total) {
        int i;
        for(i = 0; i < items.size(); i ++){
        for (Item item : items){
            if (item.equals(items.get(i))){
                total -= item.getPrice();
            }
        }
        }
    }

}
