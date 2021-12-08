package options;

import gui.ButtonCommandInterface;
import gui.GUIFactoryInterface;
import gui.GeneralGUIMakerInterface;
import login.sign_in.BackWelcomePageCommand;
import options.commands.*;
import user.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class OptionsGUIMaker implements ActionListener, GUIFactoryInterface, GeneralGUIMakerInterface {

    User user;
    static Map<String, ButtonCommandInterface> commandMap = new HashMap<>();
    JFrame frame = new JFrame();

    /**
     * A constructor for options page which user can use to guide them to one of several options
     * @param user The user who you have accessed
     */
    public OptionsGUIMaker(User user) {
        this.user = user;
    }

    /**
     * The action listener that sees what the user is doing and determines the results from this action
     * @param action the action of the user
     */
    @Override
    public void actionPerformed(ActionEvent action) {
        String buttonText = action.getActionCommand();
        ButtonCommandInterface button = commandMap.get(buttonText);
        button.apply();
        frame.dispose();
    }

    /**
     * Creates options page gui
     */
    @Override
    public void createGUI() {
        OptionsPresenter optionsPresenter = new OptionsPresenter();

        JLabel welcomeLabel = new JLabel(optionsPresenter.message1());
        JButton logout = new JButton(optionsPresenter.message2());
        JButton browse = new JButton(optionsPresenter.message4());
        JButton findSellers = new JButton(optionsPresenter.message5());
        JButton makePost = new JButton(optionsPresenter.message6());
        JButton search = new JButton(optionsPresenter.message7());
        JButton cart = new JButton(optionsPresenter.message8());

        welcomeLabel.setBounds(125, 25, 200, 35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 15));

        logout.setBounds(100, 300, 200, 35);
        logout.setFont(new Font(null, Font.PLAIN, 15));
        logout.addActionListener(this);

        browse.setBounds(100, 250, 200, 35);
        browse.setFont(new Font(null, Font.PLAIN, 15));
        browse.addActionListener(this);

        findSellers.setBounds(100, 200, 200, 35);
        findSellers.setFont(new Font(null, Font.PLAIN, 15));
        findSellers.addActionListener(this);

        makePost.setBounds(100, 150, 200, 35);
        makePost.setFont(new Font(null, Font.PLAIN, 15));
        makePost.addActionListener(this);

        search.setBounds(100, 100, 200, 35);
        search.setFont(new Font(null, Font.PLAIN, 15));
        search.addActionListener(this);

        cart.setBounds(100, 50, 200, 35);
        cart.setFont(new Font(null, Font.PLAIN, 15));
        cart.addActionListener(this);

        frame.add(welcomeLabel); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420); frame.setLayout(null); frame.setVisible(true);

        frame.add(logout); frame.add(browse); frame.add(findSellers); frame.add(makePost);
        frame.add(search); frame.add(cart);

        commandMap.put(logout.getText(), new BackWelcomePageCommand(this));
        commandMap.put(makePost.getText(), new PostCommand(this.user));
        commandMap.put(search.getText(), new SearchCommand(frame, this.user));
        commandMap.put(findSellers.getText(), new FindSellersCommand(this.user));
        commandMap.put(browse.getText(), new BrowseCommand(this.user));
        commandMap.put(cart.getText(), new CartCommand(this.user));

    }

    @Override
    public void disposeFrame() {
        frame.dispose();
    }

    // no fields to reset for current use
    @Override
    public void resetFields() {
    }
}
