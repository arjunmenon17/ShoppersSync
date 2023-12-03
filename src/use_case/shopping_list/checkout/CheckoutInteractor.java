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

    }
}
