package interface_adapter.Search;

import use_case.search.SearchInputBoundary;
import use_case.search.SearchInputData;

public class SearchController {

    final SearchInputBoundary searchUseCaseInteractor;

    public SearchController(SearchInputBoundary searchUseCaseInteractor) {

        this.searchUseCaseInteractor = searchUseCaseInteractor;


    }

    public void execute(String id){
        SearchInputData searchInputData = new SearchInputData(id);

        searchUseCaseInteractor.execute(searchInputData);
    }

}
