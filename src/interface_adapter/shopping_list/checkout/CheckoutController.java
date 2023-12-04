package interface_adapter.shopping_list.checkout;
import use_case.shopping_list.checkout.CheckoutInputBoundary;
import entity.Product;
import interface_adapter.shopping_list.ShoppingListController;

import java.util.List;

public class CheckoutController {
  
    private final CheckoutInputBoundary checkoutShoppingListUseCase;

    public CheckoutController(CheckoutInputBoundary checkoutShoppingListUseCase) {
        this.checkoutShoppingListUseCase = checkoutShoppingListUseCase;
    }

    public void execute(List<Product> products) {
        checkoutShoppingListUseCase.execute(products);
    }
}
