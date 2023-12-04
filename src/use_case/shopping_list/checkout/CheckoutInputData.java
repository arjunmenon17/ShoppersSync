package use_case.shopping_list.checkout;

import entity.Product;

import java.util.List;

public class CheckoutInputData {//
    private final List<Product> productList;

    public CheckoutInputData(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

}
