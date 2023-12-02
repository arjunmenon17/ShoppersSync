package view;

import entity.CommonProduct;
import entity.Product;
import interface_adapter.shopping_list.ShoppingListObserver;
import interface_adapter.shopping_list.ShoppingListState;
import interface_adapter.shopping_list.ShoppingListViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingListView implements ShoppingListObserver {

    JFrame frame = new JFrame("Shopping List");
    JList<CommonProduct> list = new JList<>();
    DefaultListModel<CommonProduct> model = new DefaultListModel<>();

    JButton addButton = new JButton(ShoppingListViewModel.ADD_BUTTON_LABEL);
    JButton clearButton = new JButton(ShoppingListViewModel.CLEAR_BUTTON_LABEL);
    JButton checkoutButton = new JButton(ShoppingListViewModel.CHECKOUT_BUTTON_LABEL);

    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JSplitPane splitPane = new JSplitPane();

    private ShoppingListViewModel viewModel;
    public void updateShoppingList(Product product){
        if (product != null) {
            model.addElement((CommonProduct) product);
        }
    }


    public ShoppingListView(ShoppingListViewModel viewModel) {
        this.viewModel = viewModel;

        list.setModel(model);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                viewModel.firePropertyChanged();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewModel.firePropertyChanged();
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewModel.firePropertyChanged();
            }
        });


        splitPane.setLeftComponent(new JScrollPane(list));
        panel.add(label);
        panel.add(addButton);
        panel.add(clearButton);
        panel.add(checkoutButton);
        splitPane.setRightComponent(panel);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(splitPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
