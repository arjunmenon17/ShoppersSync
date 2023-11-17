package interface_adapter.shopping_list;

import use_case.add_list.AddInputBoundary;

public class ShoppingListController {

    //It makes sense??
    final AddInputBoundary addInputBoundary;

    public ShoppingListController(AddInputBoundary addInputBoundary) {

        this.addInputBoundary = addInputBoundary;
    }



}
