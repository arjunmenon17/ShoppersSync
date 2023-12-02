package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_list.ShoppingListController;
import interface_adapter.shopping_list.ShoppingListViewModel;
import view.ShoppingListView;

public class ShoppingListUseCaseFactory {

    private ShoppingListUseCaseFactory() {}

    public static ShoppingListView create(ViewManagerModel viewManagerModel, ShoppingListViewModel shoppingListViewModel){

        ShoppingListView shoppingListView = new ShoppingListView(shoppingListViewModel);
        shoppingListViewModel.addObserver(shoppingListView);
        return shoppingListView;
    }

    private static ShoppingListController createShoppingListUseCase(ShoppingListViewModel shoppingListViewModel) {

        return null;

    }


}