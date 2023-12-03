package use_case.shopping_list.checkout;

import entity.Product;

import java.util.List;

public interface CheckoutDataAccessInterface {
    public void checkoutProductsInShoppingList(List<Product> productList);
}
