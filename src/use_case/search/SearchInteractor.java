package use_case.search;


import entity.ProductFactory;

public class SearchInteractor implements SearchInputBoundary {

    final SearchOutputBoundary searchOutputBoundary;
    final ProductFactory productFactory;


    public SearchInteractor(SearchOutputBoundary searchOutputBoundary, ProductFactory productFactory) {

        this.searchOutputBoundary = searchOutputBoundary;
        this.productFactory = productFactory;

    }



    @Override
    public void execute(SearchInputData searchInputData) {

    }
}
