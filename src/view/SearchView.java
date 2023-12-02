package view;

import interface_adapter.Search.SearchController;
import interface_adapter.Search.SearchState;
import interface_adapter.Search.SearchViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchView extends JFrame {
    public JPanel panelMain;
    private JTextField searchInputField;
    private JButton searchButton;
    private JButton addButton;
    private JPanel productPanel;
    private JButton searchClearTextButton;
    private JLabel PRODUCT_NAME;
    private JLabel PRODUCT_DESCRIPTION;
    private JLabel PRODUCT_PRICE;

    private SearchViewModel viewModel;

    private final SearchController searchController;
    public void updateProductInformation(String productName, float productPrice) {
        PRODUCT_NAME.setText("Product Name: " + productName);
        PRODUCT_PRICE.setText("Product Price: " + productPrice);
    }

    public SearchView(SearchViewModel viewModel, SearchController searchController) {
        this.viewModel = viewModel;
        this.searchController = searchController;

        setContentPane(panelMain);
        setTitle("ShopperSYNC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 600);
        setVisible(true);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //viewModel.setSearchInput(searchInputField.getText());
                //viewModel.firePropertyChanged();
                if (e.getSource().equals(searchButton)) {

                    searchController.execute(searchInputField.getText());
                    SearchState searchState = viewModel.getState();
                    updateProductInformation(searchState.getProductName(),
                            searchState.getProductPrice());
                }


            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewModel.firePropertyChanged();
            }
        });

        searchClearTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchInputField.setText("");
            }
        });
    }
}