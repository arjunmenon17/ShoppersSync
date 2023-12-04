package app;

import data_access.FileUserDataAccessObject;
import interface_adapter.Search.SearchViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_list.ShoppingListViewModel;
import use_case.search.calc_score.CalcScoreDataAccessInterface;
import use_case.shopping_list.InMemoryShoppingListDataAccess;
import use_case.shopping_list.add.AddDataAccessInterface;
import use_case.shopping_list.checkout.CheckoutDataAccessInterface;
import use_case.shopping_list.clear.ClearDataAccessInterface;
import use_case.shopping_list.remove_list.RemoveDataAccessInterface;
import view.SearchView;
import view.ShoppingListView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {

//        JFrame application = new JFrame("ShopperSYNC");
//        //application.setSize();
//        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//
//        CardLayout searchCardLayout = new CardLayout();
//
//        JPanel views = new JPanel(searchCardLayout);
//        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
//        new ViewManager(views, searchCardLayout, viewManagerModel);

        ShoppingListViewModel shoppingListViewModel = new ShoppingListViewModel();
        RemoveDataAccessInterface removeDataAccessInterface = new InMemoryShoppingListDataAccess();
        ClearDataAccessInterface clearDataAccessInterface = new InMemoryShoppingListDataAccess();
//        new ShoppingListView(shoppingListViewModel);
        CheckoutDataAccessInterface checkoutDataAccessInterface = new InMemoryShoppingListDataAccess();
        ShoppingListUseCaseFactory.create(viewManagerModel, shoppingListViewModel, removeDataAccessInterface,
                clearDataAccessInterface, checkoutDataAccessInterface);

        SearchViewModel searchViewModel = new SearchViewModel();
        AddDataAccessInterface addDataAccess = new InMemoryShoppingListDataAccess();
        CalcScoreDataAccessInterface calcScoreDataAccessInterface = new FileUserDataAccessObject();
        SearchUseCaseFactory.create(viewManagerModel, searchViewModel, shoppingListViewModel, addDataAccess, calcScoreDataAccessInterface);

//        application.pack();
//        application.setVisible(true);



    }
}