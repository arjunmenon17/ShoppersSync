package interface_adapter.shopping_list;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListState {
    private List<Product> productList = new ArrayList<>();
    private String errorMessage;

    private float total_price = 0.00F;

    public ShoppingListState(ShoppingListState copy) {
        productList = copy.productList;
        errorMessage = copy.errorMessage;
    }
    public ShoppingListState() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
