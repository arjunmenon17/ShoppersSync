package use_case.shopping_list.checkout;

public interface CheckoutOutputBoundary {

    void prepareSuccessView(CheckoutOutputData total_price); //prepare success
//
    void prepareFailView(String error);

}
