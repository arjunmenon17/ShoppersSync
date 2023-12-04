import entity.CommonProductFactory;
import entity.Product;
import interface_adapter.Search.SearchController;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_list.ShoppingListPresenter;
import interface_adapter.shopping_list.ShoppingListViewModel;
import interface_adapter.shopping_list.add.AddController;
import org.junit.jupiter.api.Test;
import use_case.shopping_list.InMemoryShoppingListDataAccess;
import use_case.shopping_list.add.AddInteractor;
import use_case.shopping_list.add.AddOutputBoundary;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    @Test
    public void testSearchProduct_Success() {
        CommonProductFactory productFactory = new CommonProductFactory();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        SearchController searchController = new SearchController();

        assertTrue();

    }
}
