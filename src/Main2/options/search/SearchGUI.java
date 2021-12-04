package options.search;

import options.OptionsGUI;
import productFunctions.Product;
import userFunctions.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchGUI implements ActionListener {
    SearchPresenterInterface searchPresenter = new SearchPresenter();
    JFrame frame = new JFrame();
    // JLabel welcomeLabel = new JLabel(searchPresenter.searchButton());
    JLabel searchLabel = new JLabel(searchPresenter.searchButton());
    JButton search = new JButton(searchPresenter.searchButton());
    JTextField searchBar = new JTextField();

    JButton clear = new JButton(searchPresenter.clearButton());
    JButton back = new JButton(searchPresenter.backButton());

    JLabel messageLabel = new JLabel(searchPresenter.searchInstructions());
    User user;


    public SearchGUI(User user) {
        this.user = user;

        messageLabel.setBounds(70, 100, 250, 35);
        messageLabel.setFont(new Font("Serif", Font.PLAIN, 14));

        // search bar + search button
        searchLabel.setBounds(50, 50, 200, 35);
        searchBar.setBounds(125, 50, 200, 35);
        search.setBounds(125, 100, 200, 35);
        search.setFont(new Font(null, Font.PLAIN, 15));
        search.addActionListener(this);

        // button to clear the search bar
        clear.setBounds(125, 150, 200, 35);
        clear.setFont(new Font(null, Font.PLAIN, 15));
        clear.addActionListener(this);

        // go back button
        back.setBounds(125, 300, 100, 35);
        back.setFont(new Font(null, Font.PLAIN, 15));
        back.addActionListener(this);

        frame.add(searchLabel);
        frame.add(search);
        frame.add(searchBar);
        frame.add(clear);
        frame.add(back);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    /**
     * The action listener that sees what the user is doing and determines the results from this action.
     * @param action the action of the user
     */
    @Override
    public void actionPerformed(ActionEvent action) {
        if(action.getSource() == back){
            frame.dispose();
            OptionsGUI optionsGUI = new OptionsGUI(user);
        }

        if(action.getSource() == clear) {
            searchBar.setText("");
        }

        if(action.getSource() == search) {
            String tag = searchBar.getText();
            SearchController searchController = new SearchController(this.user);
            ArrayList<String> searchList = null;
            try {
                searchList = searchController.getProductID(tag);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            frame.dispose();
            assert searchList != null;
            ScrollSearchGui scrollSearchGUI = new ScrollSearchGui(user, searchList);


        }

    }

}
