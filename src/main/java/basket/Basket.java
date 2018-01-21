package basket;

import discount.IDiscount;

import java.util.ArrayList;

public class Basket {

    ArrayList<Item> items;
    ArrayList<IDiscount> discounts;
    double total;

    public Basket() {
        this.items = new ArrayList<>();
        this.discounts = new ArrayList<>();
        this.total = 0.0;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<IDiscount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(ArrayList<IDiscount> discounts) {
        this.discounts = discounts;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }



    public void updateTotal(Item item) {
        total += item.getPrice();
    }

    public void addItem(Item item) {
        this.items.add(item);
        updateTotal(item);
    }

    public void addDiscount(IDiscount discount) {
        this.discounts.add(discount);
    }

    public void applyDiscounts(){
        for (IDiscount discount : discounts){
             setTotal(discount.applyDiscount(items, total));
        }
    }

    public void updateAllPrices() {
        for (Item item : items){
            this.total += item.getPrice();
        }
    }
}
