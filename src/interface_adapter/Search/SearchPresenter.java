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
        searchState.setProduct(response.getProduct());
        searchState.setProductName(response.getProduct().getName());
        searchState.setProductPrice(response.getProduct().getPrice());
        searchState.setProductDescription(response.getProduct().getDescription());
        searchState.setProductImage(response.getProduct().getImage());
        searchState.setProductBrand(response.getProduct().getBrand());
        searchState.setESG(response.getProduct().environmentalScore());
        searchState.setSearchError(null);

        this.searchViewModel.setState(searchState);
        searchViewModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        SearchState searchState = searchViewModel.getState();
        searchState.setProduct(null);
        searchState.setProductName("");
        searchState.setProductPrice(0.00F);
        searchState.setProductDescription("");
        searchState.setProductImage("");
        searchState.setProductBrand("");
        searchState.setESG(-1.00F);
        searchState.setSearchError(error);

        this.searchViewModel.setState(searchState);
        searchViewModel.firePropertyChanged();
    }
}
