package use_case.shopping_list.checkout;

import use_case.shopping_list.add.AddOutputData;

public interface CheckoutOutputBoundary {
    void prepareSuccessView(CheckoutOutputData total_price); //prepare success

    void prepareFailView(String error);
}
