package use_case.shopping_list;

import entity.Product;
import use_case.shopping_list.add.AddDataAccessInterface;
import use_case.shopping_list.clear.ClearDataAccessInterface;
import use_case.shopping_list.remove_list.RemoveDataAccessInterface;
import use_case.shopping_list.remove_list.RemoveInputData;
import use_case.shopping_list.checkout.CheckoutDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class InMemoryShoppingListDataAccess implements AddDataAccessInterface, RemoveDataAccessInterface,
        ClearDataAccessInterface, CheckoutDataAccessInterface {
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

    @Override
    public float checkoutProductsInShoppingList(List<Product> productList) {
        float total_price = 0.00F;
        // loop through products and find their prices
        for (Product product : productList) {
            total_price += product.getPrice();
        }
        return total_price;
    }

    public List<Product> getShoppingList() {
        return shoppingList;

    }
}
