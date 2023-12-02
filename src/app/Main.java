package app;

import interface_adapter.Search.SearchViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_list.ShoppingListViewModel;
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
        new ShoppingListView(shoppingListViewModel);

        SearchViewModel searchViewModel = new SearchViewModel();
        SearchUseCaseFactory.create(viewManagerModel, searchViewModel, shoppingListViewModel);

//        application.pack();
//        application.setVisible(true);



    }
}