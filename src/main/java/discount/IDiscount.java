package discount;
import basket.*;

import java.util.ArrayList;

public interface IDiscount {

    double applyDiscount(ArrayList<Item> items, double total);
}
