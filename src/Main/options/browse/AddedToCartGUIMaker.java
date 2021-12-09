package options.browse;

import gui.ButtonCommandInterface;
import gui.GUIFactoryInterface;
import options.browse.AddedToCartPresenter.EnglishAddedPresenter;
import options.browse.EmptyFeedPresenter.EnglishEmptyFeedPresenter;
import options.commands.OptionsCommand;
import user.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * JFrame GUI to call when a product was added to your options.cart from Feed
 */
public class AddedToCartGUIMaker implements ActionListener, GUIFactoryInterface {
    EnglishAddedPresenter addedPresenter = new EnglishAddedPresenter();
    JLabel addedLabel = new JLabel();
    User user;
    static Map<String, ButtonCommandInterface> commandMap = new HashMap<>();

    /**
     * Initializes add to cart gui
     *
     * @param user the user logged in
     * @param productName the name of product being added to cart
     */

    public AddedToCartGUIMaker(User user, String productName){
        addedLabel.setText(productName + addedPresenter.presentAddedToCart());
        this.user = user;
    }

    /**
     * interprets the action performed
     * @param action action performed
     */

    @Override
    public void actionPerformed(ActionEvent action) {
        String buttonText = action.getActionCommand();
        ButtonCommandInterface button = commandMap.get(buttonText);
        button.apply();
    }

    /**
     * Creates GUI for browse
     *
     */

    @Override
    public void createGUI(){
        EnglishEmptyFeedPresenter feedPresenter = new EnglishEmptyFeedPresenter();
        JFrame frame = new JFrame();
        JButton backButton = new JButton(feedPresenter.presentReturn());

        addedLabel.setBounds(25,25,400,50);
        backButton.setBounds(160, 340, 100, 25);
        backButton.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420); frame.setLayout(null); frame.setVisible(true);
        frame.add(backButton);
        frame.add(addedLabel);

        commandMap.put(backButton.getText(), new OptionsCommand(frame, this.user));
    }
}
