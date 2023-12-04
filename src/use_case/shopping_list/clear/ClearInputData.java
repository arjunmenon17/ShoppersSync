package use_case.shopping_list.clear;

import entity.Product;

import java.util.ArrayList;

public class ClearInputData {
    private final ArrayList<Product> productList;

    public ClearInputData(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<Product> getProducts() {return productList;}
}
