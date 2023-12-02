package use_case.shopping_list.add;

import entity.Product;

public class AddInteractor implements AddInputBoundary{
    private final AddDataAccessInterface dataAccess; //DataAccess
    private final AddOutputBoundary outputBoundary; // Presenter

    public AddInteractor(AddDataAccessInterface dataAccess, AddOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    public void execute(Product product) {
        try {
            dataAccess.addProductToShoppingList(product);
            outputBoundary.prepareSuccessView(product);
        } catch (Exception e){
            outputBoundary.prepareFailView("Failed to add the product to the list");
        }
    }
}
