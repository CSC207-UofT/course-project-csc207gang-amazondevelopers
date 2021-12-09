package login.sign_in;

import gui.ButtonCommandInterface;
import gui.GUIFactoryInterface;
import gui.GeneralGUIMakerInterface;
import login.sign_in.SignInPresenter.EnglishSignInPresenter;
import user.User;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Uses java swing to Take user input for signin credentials to sign user in.
 */
public class SignInGUIMaker implements ActionListener, GUIFactoryInterface, GeneralGUIMakerInterface {
    EnglishSignInPresenter englishSignInPresenter = new EnglishSignInPresenter();
    JFrame frame = new JFrame();
    JButton loginButton = new JButton(englishSignInPresenter.presentLogin());
    JButton resetButton = new JButton(englishSignInPresenter.presentReset());
    JButton backButton = new JButton(englishSignInPresenter.presentBack());
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel messageLabel = new JLabel(englishSignInPresenter.presentInputUsername());
    JLabel userIDLabel = new JLabel(englishSignInPresenter.presentUserID());
    JLabel userPasswordLabel = new JLabel(englishSignInPresenter.presentPassword());
    static Map<String, ButtonCommandInterface> commandMap = new HashMap<>();

    /**
     * Constructor for the SignInGUIMaker
     */
    public SignInGUIMaker(){
    }
    /**
     *
     * @param action The action event, helps to maintain the actions performed by the user and the results from their
     *          actions that they perform on the page
     */
    @Override
    public void actionPerformed(ActionEvent action) {
        String buttonText = action.getActionCommand();
        ButtonCommandInterface button = commandMap.get(buttonText);
        button.apply();
    }

    /**
     * Creates the SignInGUIMaker
     */

    @Override
    public void createGUI() {
        userIDLabel.setBounds(50, 150, 75, 25);
        userPasswordLabel.setBounds(50, 200, 75, 25);

        messageLabel.setBounds(125, 100, 250, 35);
        messageLabel.setFont(new Font("Serif", Font.PLAIN, 15));

        userIDField.setBounds(125, 150, 200, 25);
        userPasswordField.setBounds(125, 200, 200, 25);

        loginButton.setBounds(45, 250, 100, 25);
        loginButton.addActionListener(this);

        resetButton.setBounds(145, 250, 100, 25);
        resetButton.addActionListener(this);

        backButton.setBounds(245, 250, 100, 25);
        backButton.addActionListener(this);

        frame.add(messageLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(backButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        commandMap.put(backButton.getText(), new BackWelcomePageCommand(this));
        commandMap.put(resetButton.getText(), new ResetCommand(this));
        commandMap.put(loginButton.getText(), new SignInCommand(this));

    }

    public void disposeFrame(){
        frame.dispose();
    }

    public void resetFields(){
        userIDField.setText("");
        userPasswordField.setText("");
    }
}



