package use_case.shopping_list.add;

import entity.Product;

public class AddOutputData {
    private final Product product;

    private boolean useCaseFailed;

    public AddOutputData(Product product, boolean useCaseFailed) {

        this.product = product;
        this.useCaseFailed = useCaseFailed;

    }
    public Product getProduct() {return product;}
}
