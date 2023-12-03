package interface_adapter.shopping_list;

import entity.Product;
import interface_adapter.ViewManagerModel;
import use_case.shopping_list.add.AddOutputBoundary;
import use_case.shopping_list.add.AddOutputData;
import use_case.shopping_list.remove_list.RemoveOutputData;
import use_case.shopping_list.remove_list.RemoveOutputBoundary;

public class ShoppingListPresenter implements AddOutputBoundary, RemoveOutputBoundary {
    private final ShoppingListViewModel shoppingListViewModel;

    public ShoppingListPresenter(ViewManagerModel viewManagerModel, ShoppingListViewModel shoppingListViewModel) {
        this.shoppingListViewModel = shoppingListViewModel;
    }


    public void prepareSuccessView(AddOutputData newProduct) {
        ShoppingListState newState = shoppingListViewModel.getState();
        newState.addProduct(newProduct.getProduct());
        this.shoppingListViewModel.setState(newState);
        shoppingListViewModel.firePropertyChanged();
    }

    public void prepareRemoveSuccessView(RemoveOutputData removedProduct) {
        ShoppingListState newState = shoppingListViewModel.getState();
        newState.removeProduct(removedProduct.getProduct());
        this.shoppingListViewModel.setState(newState);
        shoppingListViewModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        ShoppingListState newState = shoppingListViewModel.getState();
        newState.setErrorMessage(error);
        shoppingListViewModel.setState(newState);
        shoppingListViewModel.firePropertyChanged();
    }
}
