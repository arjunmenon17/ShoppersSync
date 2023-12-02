package app;

import entity.CommonProductFactory;
import entity.ProductFactory;
import interface_adapter.Search.SearchController;
import interface_adapter.Search.SearchPresenter;
import interface_adapter.Search.SearchViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_list.ShoppingListPresenter;
import interface_adapter.shopping_list.ShoppingListViewModel;
import interface_adapter.shopping_list.add.AddController;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import use_case.shopping_list.add.AddInputBoundary;
import use_case.shopping_list.add.AddInteractor;
import use_case.shopping_list.add.AddOutputBoundary;
import view.SearchView;

public class SearchUseCaseFactory {

    private SearchUseCaseFactory() {}

    public static SearchView create(ViewManagerModel viewManagerModel, SearchViewModel searchViewModel, ShoppingListViewModel shoppingListViewModel) {

        SearchController searchController = createSearchUseCase(viewManagerModel, searchViewModel);
        AddController addController = createAddUseCase(viewManagerModel, shoppingListViewModel);

        return new SearchView(searchViewModel, searchController, addController);

    }

    private static SearchController createSearchUseCase(ViewManagerModel viewManagerModel, SearchViewModel searchViewModel) {

        SearchOutputBoundary searchOutputBoundary = new SearchPresenter(viewManagerModel, searchViewModel);
        ProductFactory productFactory = new CommonProductFactory();

        SearchInputBoundary searchInputInteractor = new SearchInteractor(searchOutputBoundary, productFactory);


        return new SearchController(searchInputInteractor);
    }
    private static AddController createAddUseCase(ViewManagerModel viewManagerModel, ShoppingListViewModel shoppingListViewModel){
        AddOutputBoundary addOutputBoundary = new ShoppingListPresenter(viewManagerModel, shoppingListViewModel);
    }
}
