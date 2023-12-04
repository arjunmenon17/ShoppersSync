package use_case.shopping_list.clear;

import use_case.shopping_list.remove_list.RemoveOutputData;

public interface ClearOutputBoundary {
    void prepareClearSuccessView();

    void prepareFailView(String error);
}
