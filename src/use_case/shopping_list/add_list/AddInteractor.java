package use_case.shopping_list.add_list;

public class AddInteractor implements AddInputBoundary {

    final AddOutputBoundary addOutputBoundary;

    public AddInteractor(AddOutputBoundary addOutputBoundary) {
        this.addOutputBoundary = addOutputBoundary;
    }


    @Override
    public void execute(AddInputData addInputData) {

    }
}
