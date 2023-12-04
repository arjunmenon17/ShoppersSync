package use_case.shopping_list.clear;

import entity.Product;
import use_case.shopping_list.remove_list.RemoveOutputData;

import java.util.ArrayList;

public class ClearInteractor implements ClearInputBoundary{
    private final ClearDataAccessInterface dataAccess;
    private final ClearOutputBoundary outputBoundary;

    public ClearInteractor(ClearDataAccessInterface dataAccess, ClearOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    public void execute() {
        try {
            dataAccess.clearShoppingList();
            outputBoundary.prepareClearSuccessView();
        } catch (Exception e) {
            outputBoundary.prepareFailView("Failed to clear list");
        }
    }
}
