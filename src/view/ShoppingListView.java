package view;

import entity.CommonProduct;
import entity.Product;
import interface_adapter.shopping_list.ShoppingListObserver;
import interface_adapter.shopping_list.ShoppingListState;
import interface_adapter.shopping_list.ShoppingListViewModel;
import interface_adapter.shopping_list.clear.ClearController;
import interface_adapter.shopping_list.remove_list.RemoveController;
import interface_adapter.shopping_list.checkout.CheckoutController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ShoppingListView implements ShoppingListObserver {
    public Product removedProduct = null;
    JFrame frame = new JFrame("Shopping List");
    JList<CommonProduct> list = new JList<>();
    DefaultListModel<CommonProduct> model = new DefaultListModel<>();

    JButton clearButton = new JButton(ShoppingListViewModel.CLEAR_BUTTON_LABEL);
    JButton checkoutButton = new JButton(ShoppingListViewModel.CHECKOUT_BUTTON_LABEL);
    JButton removeButton = new JButton(ShoppingListViewModel.REMOVE_BUTTON_LABEL);

    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JSplitPane splitPane = new JSplitPane();

    private ShoppingListViewModel viewModel;
  

    public void updateShoppingList(Product product){
        if (product != null) {
            model.addElement((CommonProduct) product);
        }
        if (!frame.isVisible()) {
            frame.setVisible(true);
        }
    }
// TEMP
    public void updateRemoveShoppingList(Product product){
        if (product != null) {
            model.removeElement(product);
            label.setText("");
        }
        if (!frame.isVisible()) {
            frame.setVisible(true);
        }
    }

    public void updateClearShoppingList() {
        model.clear();
        label.setText("");
        if (!frame.isVisible()) {
            frame.setVisible(true);
        }
    }

    private void displaySelectedProductDetails(int selectedIndex) {
        if (selectedIndex >= 0 && selectedIndex < model.getSize()) {
            Product selectedProduct = model.getElementAt(selectedIndex);
            String details = "Name: " + selectedProduct.getName() + "\n"
                    + "Price: $" + selectedProduct.getPrice();
            label.setText(details);
        }
    }
    private void initializeListSelectionListener() {
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    displaySelectedProductDetails(selectedIndex);
                    removedProduct = model.getElementAt(selectedIndex);
                }
            }
        });
    }


    public ShoppingListView(ShoppingListViewModel viewModel, RemoveController removeController,
                            ClearController clearController, CheckoutController checkoutController) {
        this.viewModel = viewModel;


        list.setModel(model);

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        frame.setSize(700, 300);


        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearController.executeClear();
                updateClearShoppingList();
                viewModel.firePropertyChanged();
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Product> products = viewModel.getState().getProductList();
                if (!products.isEmpty()) {
                    checkoutController.execute(products);
                    ShoppingListState shoppingListState = viewModel.getState();
                    float total_price = shoppingListState.get_total_price();
                    // calculate the tax value
                    float tax = Math.round(total_price * 0.13F);
                    JOptionPane.showMessageDialog(null, total_price + "\n" + "+ " + tax + " (GST)" + "\n" + "----------" + "\n" + "$ " + (total_price + tax),
                            "Checkout", JOptionPane.INFORMATION_MESSAGE);
                    viewModel.firePropertyChanged();
                }
                else{
                    JOptionPane.showMessageDialog(null, "No products available to checkout",
                            "No Products Found", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (removedProduct != null) {
                    removeController.execute(removedProduct);
                    updateRemoveShoppingList(removedProduct);
                    viewModel.firePropertyChanged();
                    removedProduct = null;
                }
                else{
                    JOptionPane.showMessageDialog(null, "No product selected",
                            "Product Not Found", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        splitPane.setLeftComponent(new JScrollPane(list));
        panel.add(label);
        panel.add(clearButton);
        panel.add(checkoutButton);
        panel.add(removeButton);
        splitPane.setRightComponent(panel);

        initializeListSelectionListener();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(splitPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

}}
