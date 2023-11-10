package view;

import interface_adapter.shopping_list.ShoppingListController;
import interface_adapter.shopping_list.ShoppingListState;
import interface_adapter.shopping_list.ShoppingListViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ShoppingListView extends JPanel implements PropertyChangeListener {

    private final ShoppingListViewModel shoppingListViewModel;
    private final ShoppingListController shoppingListController;

    private final JButton addListButton;

    public ShoppingListView(ShoppingListViewModel viewModel, ShoppingListController controller) {
        this.shoppingListViewModel = viewModel;
        this.shoppingListController = controller;
        shoppingListViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Shopping List View");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        addListButton = new JButton("Add List");
        addListButton.addActionListener(e -> {
            // Trigger the add list action
            shoppingListController.addList(/* pass necessary parameters */);
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(addListButton);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ShoppingListState state = (ShoppingListState) evt.getNewValue();

        // Check for changes in the state and update the UI accordingly
        // For example, display success or error messages
        if (state.getSuccessMessage() != null) {
            JOptionPane.showMessageDialog(this, state.getSuccessMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
        } else if (state.getErrorMessage() != null) {
            JOptionPane.showMessageDialog(this, state.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        ShoppingListViewModel shoppingListViewModel = new ShoppingListViewModel();
        ShoppingListController shoppingListController = new ShoppingListController(/* provide dependencies */);
        ShoppingListView shoppingListView = new ShoppingListView(shoppingListViewModel, shoppingListController);

        JFrame frame = new JFrame("Shopping List App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(shoppingListView);
        frame.pack();
        frame.setVisible(true);
    }
}
