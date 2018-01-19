package discount;
import basket.*;

import java.util.ArrayList;

public interface IDiscount {

    void applyDiscount(ArrayList<Item> items, double total);
}
