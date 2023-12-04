package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_list.ShoppingListController;
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
import interface_adapter.shopping_list.ShoppingListPresenter;
import interface_adapter.shopping_list.ShoppingListViewModel;
import interface_adapter.shopping_list.clear.ClearController;
import interface_adapter.shopping_list.remove_list.RemoveController;
import use_case.shopping_list.clear.ClearDataAccessInterface;
import use_case.shopping_list.clear.ClearInputBoundary;
import use_case.shopping_list.clear.ClearInteractor;
import use_case.shopping_list.clear.ClearOutputBoundary;
import use_case.shopping_list.remove_list.*;
import view.ShoppingListView;

public class ShoppingListUseCaseFactory {

    private ShoppingListUseCaseFactory() {}


    public static ShoppingListView create(ViewManagerModel viewManagerModel,
                                          ShoppingListViewModel shoppingListViewModel,
                                          RemoveDataAccessInterface removeDataAccessInterface,
                                          ClearDataAccessInterface clearDataAccessInterface, CheckoutDataAccessInterface checkoutDataAccessInterface){

        RemoveController removeController = createRemoveUseCase(viewManagerModel, shoppingListViewModel,
                removeDataAccessInterface);
  
        CheckoutController checkoutController = createCheckoutUseCase(viewManagerModel, shoppingListViewModel, checkoutDataAccessInterface);

        ClearController clearController = createClearUseCase(viewManagerModel, shoppingListViewModel,
                clearDataAccessInterface);

        ShoppingListView shoppingListView = new ShoppingListView(shoppingListViewModel, removeController,
                clearController, checkoutController);

        shoppingListViewModel.addObserver(shoppingListView);
        return shoppingListView;
    }


    private static CheckoutController createCheckoutUseCase(ViewManagerModel viewManagerModel, ShoppingListViewModel shoppingListViewModel, CheckoutDataAccessInterface dataAccessInterface) {
        CheckoutOutputBoundary checkoutOutputBoundary = new ShoppingListPresenter(viewManagerModel, shoppingListViewModel);

        CheckoutInputBoundary checkoutInteractor = new CheckoutInteractor(dataAccessInterface, checkoutOutputBoundary);
        return new CheckoutController(checkoutInteractor);

    public static RemoveController createRemoveUseCase(ViewManagerModel viewManagerModel,
                                                       ShoppingListViewModel shoppingListViewModel,
                                                       RemoveDataAccessInterface removeDataAccessInterface) {

        RemoveOutputBoundary removeOutputBoundary = new ShoppingListPresenter(viewManagerModel, shoppingListViewModel);

        RemoveInputBoundary removeInteractor = new RemoveInteractor(removeDataAccessInterface, removeOutputBoundary);
        return new RemoveController(removeInteractor);
    }

    public static ClearController createClearUseCase(ViewManagerModel viewManagerModel,
                                                     ShoppingListViewModel shoppingListViewModel,
                                                     ClearDataAccessInterface clearDataAccessInterface) {

        ClearOutputBoundary clearOutputBoundary = new ShoppingListPresenter(viewManagerModel, shoppingListViewModel);

        ClearInputBoundary clearInteractor = new ClearInteractor(clearDataAccessInterface, clearOutputBoundary);
        return new ClearController(clearInteractor);

    }



}