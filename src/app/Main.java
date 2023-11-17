package app;

import interface_adapter.Search.SearchViewModel;
import interface_adapter.shopping_list.ShoppingListViewModel;
import view.SearchView;
import view.ShoppingListView;

import javax.swing.*;



public class Main {
    public static void main(String[] args) {
        ShoppingListViewModel shoppingListViewModel = new ShoppingListViewModel();
        new ShoppingListView(shoppingListViewModel);
        SearchViewModel searchViewModel = new SearchViewModel();
        new SearchView(searchViewModel);
    }
}