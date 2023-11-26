package use_case.search.add;

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