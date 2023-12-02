package interface_adapter.shopping_list;

import entity.Product;
import use_case.shopping_list.add.AddOutputBoundary;

public class ShoppingListPresenter implements AddOutputBoundary {
    private final ShoppingListViewModel shoppingListViewModel;

    public ShoppingListPresenter(ShoppingListViewModel shoppingListViewModel) {
        this.shoppingListViewModel = shoppingListViewModel;
    }


    public void prepareSuccessView(Product newProduct) {
        ShoppingListState newState = shoppingListViewModel.getState();
        newState.addProduct(newProduct);
        shoppingListViewModel.setState(newState);
        shoppingListViewModel.firePropertyChanged();
    }


    public void prepareFailView(String error) {
        ShoppingListState newState = new ShoppingListState();
        newState.setErrorMessage(error);
        shoppingListViewModel.setState(newState);
        shoppingListViewModel.firePropertyChanged();
    }
}
