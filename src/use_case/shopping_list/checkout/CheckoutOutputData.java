package use_case.shopping_list.checkout;

import entity.Product;

public class CheckoutOutputData {
    private final float total_score;
    private final boolean useCaseFailed;

    public CheckoutOutputData(float total_score, boolean useCaseFailed) {
        this.total_score = total_score;
        this.useCaseFailed = useCaseFailed;
    }

    public float getTotal_score() {
        return total_score;
    }
}
