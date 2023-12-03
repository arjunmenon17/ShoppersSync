package interface_adapter.shopping_list.remove_list;

import entity.Product;
import interface_adapter.shopping_list.ShoppingListController;
import use_case.shopping_list.remove_list.RemoveInputBoundary;

public class RemoveController implements ShoppingListController{
    private final RemoveInputBoundary removeFromShoppingListUseCase;

    public RemoveController(RemoveInputBoundary removeFromShoppingListUseCase) {
        this.removeFromShoppingListUseCase = removeFromShoppingListUseCase;
    }

    public void execute(Product product) {
        removeFromShoppingListUseCase.execute(product);
    }
}
