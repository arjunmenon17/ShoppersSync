package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_list.ShoppingListController;
import interface_adapter.shopping_list.ShoppingListPresenter;
import interface_adapter.shopping_list.ShoppingListViewModel;
import interface_adapter.shopping_list.add.AddController;
import interface_adapter.shopping_list.checkout.CheckoutController;
import use_case.shopping_list.add.AddDataAccessInterface;
import use_case.shopping_list.add.AddInputBoundary;
import use_case.shopping_list.add.AddInteractor;
import use_case.shopping_list.add.AddOutputBoundary;
import use_case.shopping_list.checkout.CheckoutDataAccessInterface;
import use_case.shopping_list.checkout.CheckoutInputBoundary;
import use_case.shopping_list.checkout.CheckoutInteractor;
import use_case.shopping_list.checkout.CheckoutOutputBoundary;
import view.ShoppingListView;

public class ShoppingListUseCaseFactory {

    private ShoppingListUseCaseFactory() {}

    public static ShoppingListView create(ViewManagerModel viewManagerModel, ShoppingListViewModel shoppingListViewModel, CheckoutDataAccessInterface checkoutDataAccessInterface){
        CheckoutController checkoutController = createCheckoutUseCase(viewManagerModel, shoppingListViewModel, checkoutDataAccessInterface);

        ShoppingListView shoppingListView = new ShoppingListView(shoppingListViewModel, checkoutController);
        shoppingListViewModel.addObserver(shoppingListView);
        return shoppingListView;
    }

    private static CheckoutController createCheckoutUseCase(ViewManagerModel viewManagerModel, ShoppingListViewModel shoppingListViewModel, CheckoutDataAccessInterface dataAccessInterface) {
        CheckoutOutputBoundary checkoutOutputBoundary = new ShoppingListPresenter(viewManagerModel, shoppingListViewModel);

        CheckoutInputBoundary checkoutInteractor = new CheckoutInteractor(dataAccessInterface, checkoutOutputBoundary);
        return new CheckoutController(checkoutInteractor);
    }



}