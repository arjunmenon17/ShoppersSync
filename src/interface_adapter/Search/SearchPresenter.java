package interface_adapter.Search;

import interface_adapter.ViewManagerModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

public class SearchPresenter implements SearchOutputBoundary {

    private final SearchViewModel searchViewModel;

    public SearchPresenter(ViewManagerModel viewManagerModel, SearchViewModel searchViewModel) {
        this.searchViewModel = searchViewModel;
    }

    @Override
    public void prepareSuccessView(SearchOutputData response) {

        SearchState searchState = searchViewModel.getState();
        searchState.setProductName(response.getProduct().getName());
        searchState.setProductPrice(response.getProduct().getPrice());
        searchState.setProductDescription(response.getProduct().getDescription());
        searchState.setProductImage(response.getProduct().getImage());
        searchState.setProductBrand(response.getProduct().getBrand());

        this.searchViewModel.setState(searchState);
        searchViewModel.firePropertyChanged();
    }

    public void prepareFailView() {
        SearchState searchState = searchViewModel.getState();
        searchState.setSearchError("error");
        searchViewModel.firePropertyChanged();
    }
}
