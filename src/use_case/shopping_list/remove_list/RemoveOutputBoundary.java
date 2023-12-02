package use_case.shopping_list.remove_list;

import entity.Product;

public interface RemoveOutputBoundary {
    void prepareSuccessView(Product newProduct);

    void prepareFailView(String error);
}
