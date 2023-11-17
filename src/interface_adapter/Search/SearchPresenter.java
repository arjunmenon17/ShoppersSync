package interface_adapter.Search;

import interface_adapter.Search.SearchState;
import interface_adapter.Search.SearchViewModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchPresenter implements SearchOutputBoundary {

    private final SearchViewModel searchViewModel;

    public SearchPresenter(SearchViewModel searchViewModel) {
        this.searchViewModel = searchViewModel;
    }

    @Override
    public void prepareSuccessView(SearchOutputData response) {

        SearchState searchState = searchViewModel.getState();
        searchState.setProductName(response.getProduct().getName());
        searchState.setProductPrice(response.getProduct().getPrice());
        searchState.setProductDescription(response.getProduct().getDescription());
        searchState.setProductImage(response.getProduct().getImage());

        this.searchViewModel.setState(searchState);
        searchViewModel.firePropertyChanged();
    }

    public void prepareFailView() {
        SearchState searchState = searchViewModel.getState();
        searchState.setSearchError("error");
        searchViewModel.firePropertyChanged();
    }
}
