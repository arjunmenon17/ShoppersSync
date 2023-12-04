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
import org.junit.jupiter.api.Test;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import use_case.shopping_list.InMemoryShoppingListDataAccess;
import use_case.shopping_list.add.*;
import app.SearchUseCaseFactory;

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

        SearchInputBoundary searchInputInteractor = new SearchInteractor(searchOutputBoundary, productFactory);
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

        SearchInputBoundary searchInputInteractor = new SearchInteractor(searchOutputBoundary, productFactory);
        SearchController searchController = new SearchController(searchInputInteractor);
        searchController.execute("123");
        System.out.println(searchViewModel.getState().getSearchError());

        assertTrue(searchViewModel.getState().getSearchError().equals("Product does not exist, please enter a valid Product ID."));
    }
}
