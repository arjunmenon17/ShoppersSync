package interface_adapter.shopping_list;

import use_case.shopping_list.add.AddInputData;

public interface ShoppingListController {
    public void execute(AddInputData input);
}
