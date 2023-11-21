package use_case.shopping_list.remove_list;

import entity.Product;

public class RemoveOutputData {
    private final boolean useCaseFailed;

    public RemoveOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    boolean getUseCaseFailed() {return useCaseFailed;}
}
