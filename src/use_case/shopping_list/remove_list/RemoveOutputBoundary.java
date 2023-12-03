package use_case.shopping_list.remove_list;

import entity.Product;

public interface RemoveOutputBoundary {
    void prepareRemoveSuccessView(RemoveOutputData newProduct);

    void prepareFailView(String error);
}
