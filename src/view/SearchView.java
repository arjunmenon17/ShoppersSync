package view;

import interface_adapter.Search.SearchController;

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

    private final SearchController searchController;


    public SearchView(SearchController searchController) {
        this.searchController = searchController;


        setContentPane(panelMain);
        setTitle("ShopperSYNC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 600 );
        setVisible(true);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(searchButton)) {

                    searchController.execute(searchInputField.getText());

                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
