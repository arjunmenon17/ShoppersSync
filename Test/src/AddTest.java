import entity.CommonProduct;
import entity.Product;
import entity.CommonProductFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_list.ShoppingListPresenter;
import interface_adapter.shopping_list.ShoppingListViewModel;
import interface_adapter.shopping_list.add.AddController;
import org.junit.jupiter.api.Test;
import use_case.shopping_list.InMemoryShoppingListDataAccess;
import use_case.shopping_list.add.*;
import app.SearchUseCaseFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class AddTest {

    @Test
    public void testAddProductToShoppingList_Success() {
        InMemoryShoppingListDataAccess mockDataAccess = new InMemoryShoppingListDataAccess();
        CommonProductFactory productFactory = new CommonProductFactory();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ShoppingListViewModel shoppingListViewModel = new ShoppingListViewModel();
        Product sampleProduct = productFactory.create("Soccer Ball", 10.99f, "Nike", "Nice Ball", "", 0.4f);
        AddOutputBoundary mockAddOutputBoundary = new ShoppingListPresenter(viewManagerModel, shoppingListViewModel);
        AddInteractor addInteractor = new AddInteractor(mockDataAccess, mockAddOutputBoundary);


        AddController addController = new AddController(addInteractor);
        addController.execute(sampleProduct);

        assertTrue(mockDataAccess.getShoppingList().contains(sampleProduct));

    }
    @Test
    public void testAddProductToShoppingList_Failure() {
        // Doesn't fail because there is an explicit if statement to check if the product is null

    }
}
