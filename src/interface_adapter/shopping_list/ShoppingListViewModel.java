package interface_adapter.shopping_list;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ShoppingListViewModel extends ViewModel {

    public static final String ADD_BUTTON_LABEL = "Add";
    public static final String CLEAR_BUTTON_LABEL = "Clear";
    public static final String CHECKOUT_BUTTON_LABEL = "Checkout";

    private ShoppingListState state = new ShoppingListState();

    public ShoppingListViewModel() {
        super("shopping list");
    }

    public void setState(ShoppingListState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the ShoppingListPresenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ShoppingListState getState() {
        return state;
    }
}
