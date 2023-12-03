package view;

import entity.Product;
import interface_adapter.Search.SearchController;
import interface_adapter.Search.SearchState;
import interface_adapter.Search.SearchViewModel;
import interface_adapter.shopping_list.ShoppingListViewModel;
import interface_adapter.shopping_list.add.AddController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class SearchView extends JFrame {
    public JPanel panelMain;
    private JTextField searchInputField;
    private JButton searchButton;
    private JButton addButton;
    private JPanel productPanel;
    private JButton searchClearTextButton;
    private JLabel PRODUCT_NAME;
    private JLabel PRODUCT_DESCRIPTION;
    private JLabel PRODUCT_BRAND;
    private JLabel PRODUCT_IMAGE;
    private JLabel PRODUCT_PRICE;
    private JLabel PRODUCT_ESG;

    private SearchViewModel viewModel;

    private final SearchController searchController;
    private final AddController addController;
    public void updateProductInformation(String productName, float productPrice, String brand, String productDescription, String image_url, float esg) {

        PRODUCT_NAME.setText(productName);
        PRODUCT_NAME.setFont(new Font("Serif", Font.BOLD, 25));
        PRODUCT_PRICE.setText("Costs: $" + productPrice);
        PRODUCT_PRICE.setFont(new Font("Serif", Font.PLAIN, 20));
        PRODUCT_BRAND.setText("This product was manufactured by " + brand);
        PRODUCT_BRAND.setFont(new Font("Serif", Font.PLAIN, 20));
        PRODUCT_DESCRIPTION.setText("<html>" + productDescription.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        PRODUCT_DESCRIPTION.setFont(new Font("Serif", Font.PLAIN, 20));

        if (esg == -1.00F) {
            PRODUCT_ESG.setText("Environmental Social Governance Score unavailable.");
            PRODUCT_ESG.setFont(new Font("Serif", Font.PLAIN, 20));
        }
        PRODUCT_ESG.setText("Environmental Social Governance Score: " + esg);
        PRODUCT_ESG.setFont(new Font("Serif", Font.PLAIN, 20));

        try {
            URL url = new URL(image_url);
            ImageIcon image = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT));
            PRODUCT_IMAGE.setIcon(image);
            PRODUCT_IMAGE.setText("");

        }
        catch (Exception e) {
            PRODUCT_IMAGE.setIcon(null);
            PRODUCT_IMAGE.setText("Image not found.");
            PRODUCT_IMAGE.setFont(new Font("Serif", Font.PLAIN, 25));
            PRODUCT_BRAND.setText("");
            PRODUCT_ESG.setText("");
        }

    }

    public SearchView(SearchViewModel viewModel, SearchController searchController, AddController addController, ShoppingListViewModel shoppingListViewModel) {
        this.viewModel = viewModel;
        this.searchController = searchController;
        this.addController = addController;

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
                            searchState.getProductPrice(), searchState.getProductBrand(), searchState.getProductDescription(), searchState.getProductImage(), searchState.getProductESG());
                    if (searchState.getSearchError() != null) {

                        JOptionPane.showMessageDialog(null, searchState.getSearchError(),
                                "Please Try Again", JOptionPane.WARNING_MESSAGE);
                    }
                }


            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to execute add

                Product product = viewModel.getState().getProduct();
                if (product != null) {
                    addController.execute(product);
                    shoppingListViewModel.notifyObservers(product);
                    viewModel.firePropertyChanged();
                }
                else{
                    JOptionPane.showMessageDialog(null, "No product available",
                            "Product Not Found", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        searchClearTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clears all text and images.
                searchInputField.setText("");
                PRODUCT_NAME.setText("");
                PRODUCT_PRICE.setText("");
                PRODUCT_BRAND.setText("");
                PRODUCT_DESCRIPTION.setText("");
                PRODUCT_ESG.setText("");
                PRODUCT_IMAGE.setText("");
                PRODUCT_IMAGE.setIcon(null);

            }
        });
    }
}