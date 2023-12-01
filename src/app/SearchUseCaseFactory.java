package app;

import entity.CommonProductFactory;
import entity.ProductFactory;
import interface_adapter.Search.SearchController;
import interface_adapter.Search.SearchViewModel;
import interface_adapter.ViewManagerModel;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import view.SearchView;

public class SearchUseCaseFactory {

    private SearchUseCaseFactory() {}

    public static SearchView create(ViewManagerModel viewManagerModel, SearchViewModel searchViewModel) {

        SearchController searchController = createSearchUseCase(searchViewModel);

        return new SearchView(searchViewModel, searchController);

    }

    private static SearchController createSearchUseCase(SearchViewModel searchViewModel) {

        SearchOutputBoundary searchOutputBoundary = new SearchPresenter(searchViewModel);
        ProductFactory productFactory = new CommonProductFactory();

        SearchInputBoundary searchInputInteractor = new SearchInteractor(searchOutputBoundary, productFactory);


        return new SearchController(searchInputInteractor);
    }
}
