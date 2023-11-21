package entity;

import java.util.ArrayList;

public class ShoppingListCommon implements ShoppingList{
    private final ArrayList<Product> products;

    private final float totalPrice;

    private final float averageEScore;

    ShoppingListCommon(ArrayList<Product> products, float totalPrice, float averageEScore) {
        this.products = products;
        this.totalPrice = totalPrice;
        this.averageEScore = averageEScore;
    }

    @Override
    public ArrayList<Product> getProducts() {return products;}

    @Override
    public float getTotalPrice() {return totalPrice;}

    @Override
    public float getAverageEScore() {return averageEScore;}
}
