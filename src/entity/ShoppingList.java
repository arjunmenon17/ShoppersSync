package entity;

import java.util.ArrayList;

public interface ShoppingList {

    ArrayList<Product> getProducts();

    float totalPrice();

    float averageEScore();

}
