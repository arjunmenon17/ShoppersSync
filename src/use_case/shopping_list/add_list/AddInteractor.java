package use_case.shopping_list.add_list;

public class AddInteractor implements AddInputBoundary{
    private final AddDataAccessInterface dataAccess;

    public AddInteractor(AddDataAccessInterface dataAccess) {
        this.dataAccess = dataAccess;
    }
    @Override
    public void addProductToShoppingList(AddInputData input) {
        dataAccess.addProductToShoppingList(input.getProduct());
    }
}
