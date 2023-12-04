package interface_adapter.shopping_list;

import entity.Product;
import interface_adapter.ViewManagerModel;
import use_case.shopping_list.add.AddOutputBoundary;
import use_case.shopping_list.add.AddOutputData;
import use_case.shopping_list.checkout.CheckoutOutputBoundary;
import use_case.shopping_list.checkout.CheckoutOutputData;

public class ShoppingListPresenter implements AddOutputBoundary, CheckoutOutputBoundary {
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


    @Override
    public void prepareSuccessView(CheckoutOutputData checkoutOutputData) {
        ShoppingListState newState = shoppingListViewModel.getState();
        newState.set_total_score(checkoutOutputData.getTotal_score())
    }

    public void prepareFailView(String error) {
        ShoppingListState newState = shoppingListViewModel.getState();
        newState.setErrorMessage(error);
        shoppingListViewModel.setState(newState);
        shoppingListViewModel.firePropertyChanged();
    }
}
