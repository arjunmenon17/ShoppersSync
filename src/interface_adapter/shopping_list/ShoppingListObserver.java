package interface_adapter.shopping_list;

import entity.Product;

public interface ShoppingListObserver {
    void updateShoppingList(Product product);
}
