package use_case.shopping_list.remove_list;

import entity.Product;

public class RemoveInteractor implements RemoveInputBoundary{
    private final RemoveDataAccessInterface dataAccess;
    private final RemoveOutputBoundary outputBoundary;

    public RemoveInteractor(RemoveDataAccessInterface dataAccess, RemoveOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }


    public void execute(Product product) {
        try {
            dataAccess.removeProductFromShoppingList(product);
            outputBoundary.prepareSuccessView(product);
        } catch (Exception e) {
            outputBoundary.prepareFailView("Failed to remove product from the list");
        }
    }
}
