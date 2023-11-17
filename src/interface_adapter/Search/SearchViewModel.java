package interface_adapter.Search;


import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchViewModel extends ViewModel {

    public static final String SEARCH_BUTTON_LABEL = "Search";
    public static final String ADD_BUTTON_LABEL = "Add";
    public static final String CLEAR_TEXT_BUTTON_LABEL = "Clear Text";

    private String searchInput;
    private String productPanelContent;
    private SearchState state = new SearchState();

    public SearchViewModel() {
        super("search");
    }

    public void setState(SearchState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    public void setProductPanelContent(String productPanelContent) {
        this.productPanelContent = productPanelContent;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public String getProductPanelContent() {
        return productPanelContent;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this);
    }
}
