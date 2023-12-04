import app.Main;
import data_access.FileUserDataAccessObject;
import entity.CommonProduct;
import entity.Product;
import entity.CommonProductFactory;
import entity.ProductFactory;
import interface_adapter.Search.SearchController;
import interface_adapter.Search.SearchPresenter;
import interface_adapter.Search.SearchState;
import interface_adapter.Search.SearchViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_list.ShoppingListPresenter;
import interface_adapter.shopping_list.ShoppingListViewModel;
import interface_adapter.shopping_list.add.AddController;
import interface_adapter.shopping_list.clear.ClearController;
import interface_adapter.shopping_list.remove_list.RemoveController;
import org.junit.jupiter.api.Test;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import use_case.search.calc_score.CalcScoreDataAccessInterface;
import use_case.shopping_list.InMemoryShoppingListDataAccess;
import use_case.shopping_list.add.*;
import app.SearchUseCaseFactory;
import use_case.shopping_list.clear.ClearInteractor;
import use_case.shopping_list.clear.ClearOutputBoundary;
import use_case.shopping_list.remove_list.RemoveInteractor;
import use_case.shopping_list.remove_list.RemoveOutputBoundary;
import view.SearchView;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class UseCaseTests {

    @Test
    public void testAddProductToShoppingList_Success() {
        InMemoryShoppingListDataAccess mockDataAccess = new InMemoryShoppingListDataAccess();
        ProductFactory productFactory = new CommonProductFactory();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ShoppingListViewModel shoppingListViewModel = new ShoppingListViewModel();
        Product sampleProduct = productFactory.create("Soccer Ball", 10.99f, "Nike", "Nice Ball", "", 0.4f);
        AddOutputBoundary mockAddOutputBoundary = new ShoppingListPresenter(viewManagerModel, shoppingListViewModel);
        AddInteractor addInteractor = new AddInteractor(mockDataAccess, mockAddOutputBoundary);


        AddController addController = new AddController(addInteractor);
        addController.execute(sampleProduct);

        assertTrue(mockDataAccess.getShoppingList().contains(sampleProduct));
        assertTrue(shoppingListViewModel.getState().getProductList().contains(sampleProduct));
    }
    @Test
    public void testAddProductToShoppingList_Failure() {
        // Doesn't fail because there is an explicit if statement to check if the product is null

    }
    @Test
    public void testSearchProduct_Success() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SearchViewModel searchViewModel = new SearchViewModel();
        SearchOutputBoundary searchOutputBoundary = new SearchPresenter(viewManagerModel, searchViewModel);
        ProductFactory productFactory = new CommonProductFactory();
        CalcScoreDataAccessInterface calcScore = new FileUserDataAccessObject();

        SearchInputBoundary searchInputInteractor = new SearchInteractor(searchOutputBoundary, productFactory, calcScore);
        SearchController searchController = new SearchController(searchInputInteractor);
        searchController.execute("16821023");


        assertTrue(searchViewModel.getState().getProductName().equals("Mountain Dew Citrus Soda Pop, 12 oz Cans, 24 Pack"));
    }
    @Test
    public void testSearchProduct_Failure() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SearchViewModel searchViewModel = new SearchViewModel();
        SearchOutputBoundary searchOutputBoundary = new SearchPresenter(viewManagerModel, searchViewModel);
        ProductFactory productFactory = new CommonProductFactory();
        CalcScoreDataAccessInterface calcScore = new FileUserDataAccessObject();

        SearchInputBoundary searchInputInteractor = new SearchInteractor(searchOutputBoundary, productFactory, calcScore);
        SearchController searchController = new SearchController(searchInputInteractor);
        searchController.execute("123");
        System.out.println(searchViewModel.getState().getSearchError());

        assertTrue(searchViewModel.getState().getSearchError().equals("Product does not exist, please enter a valid Product ID."));
    }
    @Test
    public void testRemoveProduct_Success(){
        InMemoryShoppingListDataAccess mockDataAccess = new InMemoryShoppingListDataAccess();
        ProductFactory productFactory = new CommonProductFactory();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ShoppingListViewModel shoppingListViewModel = new ShoppingListViewModel();
        Product sampleProduct = productFactory.create("Soccer Ball", 10.99f, "Nike", "Nice Ball", "", 0.4f);
        AddOutputBoundary mockAddOutputBoundary = new ShoppingListPresenter(viewManagerModel, shoppingListViewModel);
        AddInteractor addInteractor = new AddInteractor(mockDataAccess, mockAddOutputBoundary);


        AddController addController = new AddController(addInteractor);
        addController.execute(sampleProduct);

        RemoveOutputBoundary removeOutputBoundary = new ShoppingListPresenter(viewManagerModel, shoppingListViewModel);
        RemoveInteractor removeInteractor = new RemoveInteractor(mockDataAccess, removeOutputBoundary);


        RemoveController removeController = new RemoveController(removeInteractor);
        removeController.execute(sampleProduct);

        assertFalse(mockDataAccess.getShoppingList().contains(sampleProduct));
        assertFalse(shoppingListViewModel.getState().getProductList().contains(sampleProduct));


    }
    @Test
    public void testRemoveProduct_Failure(){

    }
    @Test
    public void testClearProducts_Success(){
        InMemoryShoppingListDataAccess mockDataAccess = new InMemoryShoppingListDataAccess();
        ProductFactory productFactory = new CommonProductFactory();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ShoppingListViewModel shoppingListViewModel = new ShoppingListViewModel();
        Product sampleProduct = productFactory.create("Soccer Ball", 10.99f, "Nike", "Nice Ball", "", 0.4f);
        AddOutputBoundary mockAddOutputBoundary = new ShoppingListPresenter(viewManagerModel, shoppingListViewModel);
        AddInteractor addInteractor = new AddInteractor(mockDataAccess, mockAddOutputBoundary);


        AddController addController = new AddController(addInteractor);
        addController.execute(sampleProduct);
        addController.execute(sampleProduct); // Adds 2 of the same product to the list

        ClearOutputBoundary clearOutputBoundary = new ShoppingListPresenter(viewManagerModel, shoppingListViewModel);
        ClearInteractor clearInteractor = new ClearInteractor(mockDataAccess, clearOutputBoundary);


        ClearController clearController = new ClearController(clearInteractor);
        clearController.executeClear();

        assertFalse(mockDataAccess.getShoppingList().contains(sampleProduct));
        assertFalse(shoppingListViewModel.getState().getProductList().contains(sampleProduct));
    }
    @Test
    public void testView(){
        Main.main(null); // Ensure the views open with the main class
//        JTextField searchInputField = ma
////        ViewManagerModel viewManagerModel = new ViewManagerModel();
////        SearchViewModel searchViewModel = new SearchViewModel();
////        SearchOutputBoundary searchOutputBoundary = new SearchPresenter(viewManagerModel, searchViewModel);
////        ProductFactory productFactory = new CommonProductFactory();
////        CalcScoreDataAccessInterface calcScore = new FileUserDataAccessObject();
////
////        SearchInputBoundary searchInputInteractor = new SearchInteractor(searchOutputBoundary, productFactory, calcScore);
////        SearchController searchController = new SearchController(searchInputInteractor);
////        SearchView searchView = new SearchView()
//        searchView.searchInputField.setText("123");
//        searchView.searchButton.doClick();

        // Assert that the expected message dialog occurred
//        assertEquals("Invalid Product ID", messageDialogResult);
    }
}
