package use_case.shopping_list;

import entity.Product;
import use_case.shopping_list.add.AddDataAccessInterface;
import use_case.shopping_list.checkout.CheckoutDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class InMemoryShoppingListDataAccess implements AddDataAccessInterface, CheckoutDataAccessInterface {
    private List<Product> shoppingList = new ArrayList<>();

    public InMemoryShoppingListDataAccess() {
        this.shoppingList = getShoppingList();
    }


    public void addProductToShoppingList(Product product) {
        shoppingList.add(product);
    }

    public List<Product> getShoppingList() {
        return shoppingList;
    }

    @Override
    public float checkoutProductsInShoppingList(List<Product> productList) {
        float total_price = 0.00F;
        for (Product product: productList) {
            total_price += product.getPrice();
        }
        return total_price;
    }
}
