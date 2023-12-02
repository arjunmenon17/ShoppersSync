package use_case.shopping_list.add;

import entity.Product;

public interface AddOutputBoundary {
    void prepareSuccessView(Product newProduct); //prepare success

    void prepareFailView(String error);
}
