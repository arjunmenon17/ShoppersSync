package use_case.shopping_list.add;

import entity.Product;

public class AddInputData {
    private final Product product;

    public AddInputData(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    } // Getter method
}
