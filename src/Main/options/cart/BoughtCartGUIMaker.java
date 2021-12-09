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

public class BoughtCartGUIMaker implements ActionListener, GUIFactoryInterface {
    User user;
    static Map<String, ButtonCommandInterface> commandMap = new HashMap<>();

    /**
     * initializes bought acrt gui
     * @param user user logged in
     */

    public BoughtCartGUIMaker(User user){
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
     * Creates bough cart gui
     */

    @Override
    public void createGUI(){
        CartPresenter presenter = new CartPresenter();
        JFrame frame = new JFrame();
        JButton returnHome = new JButton("Back to Main");

        JLabel boughtCartMessage = new JLabel(presenter.boughtCartMessage());

        boughtCartMessage.setBounds(150, 100, 250, 35);
        boughtCartMessage.setFont(new Font("Serif", Font.PLAIN, 14));

        returnHome.setBounds(60, 150, 300, 25);
        returnHome.addActionListener(this);

        frame.add(returnHome);
        frame.add(boughtCartMessage);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        commandMap.put(returnHome.getText(), new OptionsCommand(frame, this.user));
    }
}

