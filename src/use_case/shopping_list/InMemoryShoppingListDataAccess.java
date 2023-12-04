package use_case.shopping_list;

import entity.Product;
import use_case.shopping_list.add.AddDataAccessInterface;
import use_case.shopping_list.clear.ClearDataAccessInterface;
import use_case.shopping_list.remove_list.RemoveDataAccessInterface;
import use_case.shopping_list.remove_list.RemoveInputData;

import java.util.ArrayList;
import java.util.List;

public class InMemoryShoppingListDataAccess implements AddDataAccessInterface, RemoveDataAccessInterface,
        ClearDataAccessInterface {
    private List<Product> shoppingList = new ArrayList<>();

    public InMemoryShoppingListDataAccess() {
        this.shoppingList = getShoppingList();
    }


    public void addProductToShoppingList(Product product) {
        shoppingList.add(product);
    }

    public void removeProductFromShoppingList(Product product) {
        shoppingList.remove(product);
    }

    public void clearShoppingList() {
        shoppingList.clear();
    }

    public List<Product> getShoppingList() {
        return shoppingList;
    }
}
