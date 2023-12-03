package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_list.ShoppingListController;
import interface_adapter.shopping_list.ShoppingListViewModel;
import interface_adapter.shopping_list.checkout.CheckoutController;
import view.ShoppingListView;

public class ShoppingListUseCaseFactory {

    private ShoppingListUseCaseFactory() {}

    public static ShoppingListView create(ViewManagerModel viewManagerModel, ShoppingListViewModel shoppingListViewModel, CheckoutController checkoutController){

        ShoppingListView shoppingListView = new ShoppingListView(shoppingListViewModel, checkoutController);
        shoppingListViewModel.addObserver(shoppingListView);
        return shoppingListView;
    }



}