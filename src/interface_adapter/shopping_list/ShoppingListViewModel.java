package interface_adapter.shopping_list;

import entity.Product;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListViewModel extends ViewModel {

    public static final String CLEAR_BUTTON_LABEL = "Clear";
    public static final String CHECKOUT_BUTTON_LABEL = "Checkout";
    public static final String REMOVE_BUTTON_LABEL = "Remove";

    private List<Product> shoppingList;
    private String errorMessage;

    private ShoppingListState state = new ShoppingListState();

    public ShoppingListViewModel() {
        super("shopping list");
    }

    private List<ShoppingListObserver> observers = new ArrayList<>();

    public void addObserver(ShoppingListObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Product product) {
        for (ShoppingListObserver observer : observers) {
            observer.updateShoppingList(product);
        }
    }

    public void setState(ShoppingListState state) {
        this.state = state;
    }
    public List<Product> getProductList() {
        return shoppingList;
    }

    public void addProduct(Product product) {
        shoppingList.add(product);
    }

    public void removeProduct(Product product) {
        shoppingList.remove(product);
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

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
