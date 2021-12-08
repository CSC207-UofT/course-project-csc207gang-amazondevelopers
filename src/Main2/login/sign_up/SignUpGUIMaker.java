package login.sign_up;


import gui.ButtonCommandInterface;
import gui.GUIFactoryInterface;
import gui.GeneralGUIMakerInterface;
import login.sign_in.BackWelcomePageCommand;
import login.sign_in.ResetCommand;
import login.sign_up.SignUpPresenter.EnglishSignUpPresenter;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Take user input for signup credentials to sign user up.
 */
public class SignUpGUIMaker implements ActionListener, GUIFactoryInterface, GeneralGUIMakerInterface {
    EnglishSignUpPresenter englishSignUpPresenter = new EnglishSignUpPresenter();
    JFrame frame = new JFrame();
    JButton signUpButton = new JButton(englishSignUpPresenter.signUp());
    JButton resetButton = new JButton(englishSignUpPresenter.reset());
    JButton backButton = new JButton(englishSignUpPresenter.back());
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel messageLabel = new JLabel(englishSignUpPresenter.message());
    JLabel userIDLabel = new JLabel(englishSignUpPresenter.userID());
    JLabel userPasswordLabel = new JLabel(englishSignUpPresenter.password());
    static Map<String, ButtonCommandInterface> commandMap = new HashMap<>();


    /**
     * Constructor is used to set the size of labels and buttons on the page
     */
    public SignUpGUIMaker() {
    }

    /**
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
     * Creates the SignUpGUIMaker
     */

    @Override
    public void createGUI(){
        userIDLabel.setBounds(50, 150, 75, 25);
        userPasswordLabel.setBounds(50, 200, 75, 25);

        messageLabel.setBounds(125, 100, 300, 35);
        messageLabel.setFont(new Font("Serif", Font.PLAIN, 15));

        userIDField.setBounds(125, 150, 200, 25);
        userPasswordField.setBounds(125, 200, 200, 25);

        signUpButton.setBounds(45, 250, 100, 25);
        signUpButton.addActionListener(this);

        resetButton.setBounds(145, 250, 100, 25);
        resetButton.addActionListener(this);

        backButton.setBounds(245, 250, 100, 25);
        backButton.addActionListener(this);

        frame.add(messageLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(signUpButton);
        frame.add(resetButton);
        frame.add(backButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        commandMap.put(backButton.getText(), new BackWelcomePageCommand(this));
        commandMap.put(resetButton.getText(), new ResetCommand(this));
        commandMap.put(signUpButton.getText(), new SignUpCommand(this));

    }

    public void disposeFrame(){
        frame.dispose();
    }

    public void resetFields(){
        userIDField.setText("");
        userPasswordField.setText("");
    }
}



