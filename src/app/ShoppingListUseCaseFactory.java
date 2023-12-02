package app;

import interface_adapter.shopping_list.ShoppingListController;
import interface_adapter.shopping_list.ShoppingListViewModel;
import view.ShoppingListView;

public class ShoppingListUseCaseFactory {

    private ShoppingListUseCaseFactory() {}

    public static ShoppingListView create(ShoppingListViewModel shoppingListViewModel){

        ShoppingListController shoppingListController = createShoppingListUseCase(shoppingListViewModel);
        return new ShoppingListView(shoppingListViewModel);
    }

    private static ShoppingListController createShoppingListUseCase(ShoppingListViewModel shoppingListViewModel) {

        return null;

    }


}