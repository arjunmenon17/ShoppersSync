package interface_adapter.shopping_list.clear;

import entity.Product;
import interface_adapter.shopping_list.ShoppingListController;
import use_case.shopping_list.clear.ClearInputBoundary;

public class ClearController implements ShoppingListController{
    private final ClearInputBoundary clearShoppingListUseCase;

    public ClearController(ClearInputBoundary clearShoppingListUseCase) {
        this.clearShoppingListUseCase = clearShoppingListUseCase;
    }

    @Override
    public void execute(Product product) {}

    public void executeClear() {
        clearShoppingListUseCase.execute();
    }
}
