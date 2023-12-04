package interface_adapter.shopping_list.add;

import entity.Product;
import interface_adapter.shopping_list.ShoppingListController;
import use_case.shopping_list.add.AddInputBoundary;
import use_case.shopping_list.add.AddInputData;

public class AddController implements ShoppingListController {
    private final AddInputBoundary addToShoppingListUseCase;

    public AddController(AddInputBoundary addToShoppingListUseCase) {
        this.addToShoppingListUseCase = addToShoppingListUseCase;
    }

    public void execute(Product product) {
        addToShoppingListUseCase.execute(product);
    }

    @Override
    public void executeClear() {}
}
