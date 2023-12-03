package use_case.shopping_list.checkout;

import entity.Product;
import interface_adapter.shopping_list.checkout.CheckoutController;

import java.util.List;

public class CheckoutInteractor implements CheckoutInputBoundary{\
    private final CheckoutDataAccessInterface checkoutDataAccessInterface;
    private final CheckoutOutputBoundary checkoutOutputBoundary;

    public CheckoutInteractor(CheckoutDataAccessInterface checkoutDataAccessInterface, CheckoutOutputBoundary checkoutOutputBoundary){
        this.checkoutDataAccessInterface = checkoutDataAccessInterface;
        this.checkoutOutputBoundary = checkoutOutputBoundary;
    }
    @Override
    public void execute(List<Product> products) {
        try {
            checkoutDataAccessInterface.checkoutProductsInShoppingList(products);
            CheckoutOutputData checkoutOutputData = new CheckoutOutputData(products, false);
            checkoutOutputBoundary.prepareSuccessView(checkoutOutputData);
        } catch (Exception e) {
            checkoutOutputBoundary.prepareFailView("Failed to checkout products")
        }
    }
}
