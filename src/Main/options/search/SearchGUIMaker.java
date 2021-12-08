package options.search;

import gui.ButtonCommandInterface;
import gui.GUIFactoryInterface;
import gui.GeneralGUIMakerInterface;
import login.sign_in.ResetCommand;
import options.commands.OptionsCommand;
import options.commands.ScrollSearchCommand;
import user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SearchGUIMaker implements ActionListener, GUIFactoryInterface, GeneralGUIMakerInterface {
    User user;
    static Map<String, ButtonCommandInterface> commandMap = new HashMap<>();
    public JTextField searchBar = new JTextField();
    JFrame frame = new JFrame();

    public SearchGUIMaker(User user) {
        this.user = user;
    }

    /**
     * The action listener that sees what the user is doing and determines the results from this action.
     * @param action the action of the user
     */
    @Override
    public void actionPerformed(ActionEvent action) {

        String buttonText = action.getActionCommand();
        ButtonCommandInterface button = commandMap.get(buttonText);
        button.apply();
    }

    @Override
    public void createGUI() {

        SearchPresenterInterface searchPresenter = new SearchPresenter();
        JLabel searchLabel = new JLabel(searchPresenter.searchButton());
        JButton search = new JButton(searchPresenter.searchButton());

        JButton clear = new JButton(searchPresenter.clearButton());
        JButton back = new JButton(searchPresenter.backButton());

        JLabel messageLabel = new JLabel(searchPresenter.searchInstructions());

        messageLabel.setBounds(125, 10, 250, 35);
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

        frame.add(messageLabel);
        frame.add(searchLabel);
        frame.add(search);
        frame.add(searchBar);
        frame.add(clear);
        frame.add(back);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        commandMap.put(back.getText(), new OptionsCommand(frame, this.user));
        commandMap.put(clear.getText(), new ResetCommand(this));
        commandMap.put(search.getText(), new ScrollSearchCommand(frame, this.user, this));
    }

    @Override
    public void disposeFrame() {
        frame.dispose();
    }

    @Override
    public void resetFields() {
        searchBar.setText("");
    }
}
