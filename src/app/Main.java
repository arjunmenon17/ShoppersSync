package app;

import interface_adapter.Search.SearchViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_list.ShoppingListViewModel;
import interface_adapter.shopping_list.checkout.CheckoutController;
import use_case.shopping_list.InMemoryShoppingListDataAccess;
import use_case.shopping_list.add.AddDataAccessInterface;
import use_case.shopping_list.checkout.CheckoutDataAccessInterface;
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
//        new ShoppingListView(shoppingListViewModel);
        CheckoutDataAccessInterface checkoutDataAccessInterface = new InMemoryShoppingListDataAccess();
        ShoppingListUseCaseFactory.create(viewManagerModel, shoppingListViewModel, checkoutDataAccessInterface);

        SearchViewModel searchViewModel = new SearchViewModel();
        AddDataAccessInterface addDataAccess = new InMemoryShoppingListDataAccess();
        SearchUseCaseFactory.create(viewManagerModel, searchViewModel, shoppingListViewModel, addDataAccess);

//        application.pack();
//        application.setVisible(true);



    }
}