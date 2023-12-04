import entity.CommonProductFactory;
import entity.Product;
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
import use_case.shopping_list.add.AddInteractor;
import use_case.shopping_list.add.AddOutputBoundary;
import view.SearchView;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
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

        // Checks for Search Error
        assertTrue(searchViewModel.getState().getSearchError().equals("Product does not exist, please enter a valid Product ID."));
    }
}
