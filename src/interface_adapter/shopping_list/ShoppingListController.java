package interface_adapter.shopping_list;

import entity.Product;
import use_case.shopping_list.add.AddInputData;

import java.util.List;

public interface ShoppingListController {
    public void execute(Product product); // For add and remove
}
