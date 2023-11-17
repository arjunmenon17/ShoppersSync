package use_case.search;

import entity.Product;

public class SearchOutputData {

    private final Product product;

    private boolean useCaseFailed;

    public SearchOutputData(Product product, boolean useCaseFailed) {

        this.product = product;
        this.useCaseFailed = useCaseFailed;

    }
    public Product getProduct() {return product;}
}
