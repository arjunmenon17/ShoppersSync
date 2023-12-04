package use_case.shopping_list.checkout;

import entity.Product;

import java.util.List;

public interface CheckoutDataAccessInterface {
    public float checkoutProductsInShoppingList(List<Product> productList);
}
