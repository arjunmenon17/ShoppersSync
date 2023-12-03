package use_case.shopping_list.checkout;

import entity.Product;

import java.util.List;

public interface CheckoutInputBoundary {
    void execute(List<Product> products);
}
