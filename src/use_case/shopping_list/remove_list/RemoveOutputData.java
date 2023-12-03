package use_case.shopping_list.remove_list;

import entity.Product;

public class RemoveOutputData {
    private final Product product;
    private final boolean useCaseFailed;

    public RemoveOutputData(boolean useCaseFailed, Product product) {
        this.product = product;
        this.useCaseFailed = useCaseFailed;
    }

    boolean getUseCaseFailed() {return useCaseFailed;}
    public Product getProduct() {return product;}
}
