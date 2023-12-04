package use_case.shopping_list.clear;

import entity.Product;

import java.util.ArrayList;

public class ClearOutputData {
    private final boolean useCaseFailed;

    public ClearOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    boolean getUseCaseFailed() {return useCaseFailed;}
}
