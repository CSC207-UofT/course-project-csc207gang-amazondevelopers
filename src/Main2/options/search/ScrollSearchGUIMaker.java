package options.search;


import gui.ButtonCommandInterface;
import gui.GUIFactoryInterface;
import options.commands.BuyCommand;
import options.commands.SearchCommand;
import user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ScrollSearchGUIMaker implements ActionListener, GUIFactoryInterface {

    public JLabel messageLabel = new JLabel();
    User user;
    String tag;
    static Map<String, ButtonCommandInterface> commandMap = new HashMap<>();
    public JTextField searchBar = new JTextField(10);



    public ScrollSearchGUIMaker(User user, String tag) {
        this.user = user;
        this.tag = tag;
    }

    /**
     * The action listener that sees what the user is doing and determines the results from this action.
     *
     * @param action the action of the user
     */
    @Override
    public void actionPerformed(ActionEvent action) {
        String buttonText = action.getActionCommand();
        ButtonCommandInterface button = commandMap.get(buttonText);
        button.apply();

    }

    @Override
    public void createGUI(){

        SearchPresenterInterface searchPresenter = new SearchPresenter();
        JLabel searchIntro = new JLabel(searchPresenter.inputIndex());
        JFrame frame = new JFrame();
        JButton back = new JButton(searchPresenter.backButton());
        JButton buy = new JButton(searchPresenter.buyButton());
        JPanel scrollPanel = new JPanel();
        JPanel indexPanel = new JPanel();
        JPanel titlePanel = new JPanel();
        JPanel backPanel = new JPanel();

        SearchController searchController = new SearchController(this.user);
        ArrayList<String> searchList;

        searchList = searchController.getSearchProductStrings(this.tag);

        messageLabel.setBounds(125, 125, 130, 130);


        searchIntro.setBounds(125, 20, 100, 35);
        searchIntro.setFont(new Font(null, Font.PLAIN, 13));
        titlePanel.add(searchIntro);

        titlePanel.setBounds(1, 1, 100, 35);

        scrollPanel.setBounds(125, 100, 100, 100);
        indexPanel.setBounds(125, 300, 100, 100);

        backPanel.add(back);
        backPanel.setBounds(130, 600, 100, 100);


        DefaultListModel list = new DefaultListModel();
        for (String item : searchList) {
            list.addElement(item);
        }
        JList listOfProductDisplay = new JList(list);
        JScrollPane listScroller = new JScrollPane(listOfProductDisplay);

        // back button
        back.setBounds(130, 600, 50, 35);
        back.addActionListener(this);
        listScroller.setBounds(100, 100, 100, 100);
        scrollPanel.add(listScroller);


        //buy button
        buy.setBounds(160, 300, 50, 35);
        buy.addActionListener(this);


        // search bar + search button
        // search bar + search button

        searchBar.setBounds(100, 350, 100, 35);


        searchBar.setFont(new Font(null, Font.PLAIN, 15));
        searchBar.addActionListener(this);

        indexPanel.add(searchBar);
        indexPanel.add(buy);
        indexPanel.add(back);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(listScroller);
        frame.add(titlePanel);
        frame.add(messageLabel);


        listScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(backPanel);
        frame.add(indexPanel);
        frame.add(scrollPanel);

        commandMap.put(back.getText(), new SearchCommand(frame, this.user));
        commandMap.put(buy.getText(), new BuyCommand(this.user, this.tag,this));
    }
}