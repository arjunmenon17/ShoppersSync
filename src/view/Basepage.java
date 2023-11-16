package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Basepage extends JFrame {
    public JPanel panelMain;
    private JTextField searchInputField;
    private JButton searchButton;
    private JButton addButton;
    private JPanel productPanel;
    private JButton searchClearTextButton;


    public Basepage() {

        setContentPane(panelMain);
        setTitle("ShopperSYNC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 600 );
        setVisible(true);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        searchInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
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
