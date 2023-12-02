package interface_adapter.shopping_list;

import entity.Product;
import use_case.shopping_list.add.AddInputData;

public interface ShoppingListController {
    public void execute(Product product);
}
