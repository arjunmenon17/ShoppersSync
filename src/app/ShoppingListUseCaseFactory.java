package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_list.ShoppingListController;
import interface_adapter.shopping_list.ShoppingListPresenter;
import interface_adapter.shopping_list.ShoppingListViewModel;
import interface_adapter.shopping_list.add.AddController;
import interface_adapter.shopping_list.remove_list.RemoveController;
import use_case.shopping_list.remove_list.*;
import view.ShoppingListView;

public class ShoppingListUseCaseFactory {

    private ShoppingListUseCaseFactory() {}

    public static ShoppingListView create(ViewManagerModel viewManagerModel,
                                          ShoppingListViewModel shoppingListViewModel,
                                          RemoveDataAccessInterface removeDataAccessInterface){

        RemoveController removeController = createRemoveUseCase(viewManagerModel, shoppingListViewModel,
                removeDataAccessInterface);

        ShoppingListView shoppingListView = new ShoppingListView(shoppingListViewModel, removeController);
        shoppingListViewModel.addObserver(shoppingListView);
        return shoppingListView;
    }

    public static RemoveController createRemoveUseCase(ViewManagerModel viewManagerModel,
                                                       ShoppingListViewModel shoppingListViewModel,
                                                       RemoveDataAccessInterface removeDataAccessInterface) {

        RemoveOutputBoundary removeOutputBoundary = new ShoppingListPresenter(viewManagerModel, shoppingListViewModel);

        RemoveInputBoundary removeInteractor = new RemoveInteractor(removeDataAccessInterface, removeOutputBoundary);
        return new RemoveController(removeInteractor);
    }



}