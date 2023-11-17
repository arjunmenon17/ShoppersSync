package app;

import interface_adapter.Search.SearchViewModel;
import interface_adapter.shopping_list.ShoppingListViewModel;
import view.SearchView;
import view.ShoppingListView;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;



public class Main {
    public static void main(String[] args) throws IOException {
        ShoppingListViewModel shoppingListViewModel = new ShoppingListViewModel();
        new ShoppingListView(shoppingListViewModel);
        SearchViewModel searchViewModel = new SearchViewModel();
        new SearchView(searchViewModel);

    }


    public static void temp(String[]args) throws IOException {
            String urlString = "https://api.bluecartapi.com/request?api_key=17E691EE2B274440B026E21B2DE8CE76&type=product&item_id=782866746";
            URL fitbit  = new URL(urlString);
            URLConnection conn = fitbit.openConnection();
            InputStream stuff = conn.getInputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(stuff));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());

            // print result
            System.out.println(response.toString());


        }

    }