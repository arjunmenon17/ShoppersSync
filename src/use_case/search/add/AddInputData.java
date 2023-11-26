package use_case.search.add;
import entity.Product;

public class AddInputData {
    private final Product product;

    public AddInputData(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
