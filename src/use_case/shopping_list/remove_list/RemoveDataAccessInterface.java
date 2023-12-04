package use_case.shopping_list.remove_list;

import entity.Product;

public interface RemoveDataAccessInterface {
    void removeProductFromShoppingList(Product product);
}
