package use_case.shopping_list.add_list;

import entity.Product;

public class AddInputData {

    private final Product product;

    public AddInputData(Product product) {
        this.product = product;
    }

    Product getProduct() {return product;}
}
