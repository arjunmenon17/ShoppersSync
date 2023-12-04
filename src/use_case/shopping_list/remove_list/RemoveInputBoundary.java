package use_case.shopping_list.remove_list;

import entity.Product;

public interface RemoveInputBoundary {
    void execute(Product product);
}
