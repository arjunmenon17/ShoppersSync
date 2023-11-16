package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListView {

    JFrame frame = new JFrame("Shopping List");
    JList<Product> list = new JList<>();
    DefaultListModel<Product> model = new DefaultListModel<>();

    JButton addButton = new JButton("Add");
    JButton clearButton = new JButton("Clear");
    JButton checkoutButton = new JButton("Checkout");

    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JSplitPane splitPane = new JSplitPane();

    public ShoppingListView() {

        list.setModel(model);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                addProduct();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                clearShoppingList();
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                checkout();
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



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShoppingListView();
            }
        });
    }

    private static class Product {
        private String name;
        private BigDecimal price;
        private String desc;

        public Product(String name, BigDecimal price, String desc) {
            this.name = name;
            this.price = price;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public String getDesc() {
            return desc;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
