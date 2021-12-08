package options.cart;

import gui.ButtonCommandInterface;
import gui.GUIFactoryInterface;
import options.commands.OptionsCommand;
import user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class EmptyCartGUIMaker implements ActionListener, GUIFactoryInterface {
    static Map<String, ButtonCommandInterface> commandMap = new HashMap<>();
    User user;

    /**
     * Initializes empty cart gui
     *
     * @param user user logged in
     */

    public EmptyCartGUIMaker(User user) {
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

    @Override
    public void createGUI() {

        CartPresenter presenter = new CartPresenter();
        JFrame frame = new JFrame();
        JButton returnHome = new JButton("Back");

        JLabel emptyCartMessage = new JLabel(presenter.emptyCartMessage());
        emptyCartMessage.setBounds(150, 100, 250, 35);
        emptyCartMessage.setFont(new Font("Serif", Font.PLAIN, 14));

        returnHome.setBounds(60, 150, 300, 25);
        returnHome.addActionListener(this);

        frame.add(returnHome);
        frame.add(emptyCartMessage);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        commandMap.put(returnHome.getText(), new OptionsCommand(frame, this.user));
    }
}
