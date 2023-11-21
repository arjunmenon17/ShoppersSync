package use_case.shopping_list.remove_list;

import entity.Product;

public class RemoveInputData {
    private final Product product;

    public RemoveInputData(Product product) {
        this.product = product;
    }

    Product getProduct() {return product;}
}
