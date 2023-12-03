package interface_adapter.shopping_list.add;

import entity.Product;
import interface_adapter.shopping_list.ShoppingListController;
import use_case.shopping_list.add_list.AddInputBoundary;

public class AddController implements ShoppingListController {

    final AddInputBoundary addUseCaseInteractor;


    public AddController(AddInputBoundary addUseCaseInteractor) {
        this.addUseCaseInteractor = addUseCaseInteractor;
    }

    public void execute(Product product) {

    }
}
