package interface_adapter.shopping_list;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListState {
    private List<Product> productList;
    private String errorMessage;

    public ShoppingListState() {
        this.productList = new ArrayList<>();
        this.errorMessage = null;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
