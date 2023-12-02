package use_case.shopping_list.add;

import entity.Product;

public class AddInteractor implements AddInputBoundary{
    private final AddDataAccessInterface dataAccess; //DataAccess

    public AddInteractor(AddDataAccessInterface dataAccess) {
        this.dataAccess = dataAccess;
    }

    public void execute(Product product) {
        // Add the product to the shopping list in the data source
        dataAccess.addProductToShoppingList(product);
    }
}
