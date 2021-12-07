package login.sign_in;

import gui.GUI;
import gui.GUIFactoryInterface;
import login.GetUserGateway;
import login.sign_in.SignInPresenter.EnglishSignInPresenter;
import login.welcome_page.WelcomePageGUIMaker;
import options.OptionsGUI;
import user.User;
import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Uses java swing to Take user input for signin credentials to sign user in.
 */
public class SignInGUIMaker implements ActionListener, GUIFactoryInterface {
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
        EnglishSignInPresenter presenter = new EnglishSignInPresenter();
        if(action.getSource()==backButton) {
            frame.dispose();
            try {
                WelcomePageGUIMaker welcomePageGUIMaker = new WelcomePageGUIMaker();
                welcomePageGUIMaker.createGUI();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(action.getSource()==resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if(action.getSource()==loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            SignInController signInController = new SignInController();
            try {
                boolean matchPass = signInController.checkPassMatch(userID, password);
                if (matchPass){
                    frame.dispose();
                    GetUserGateway getUserGateway = new GetUserGateway();
                    User user = getUserGateway.getUser(userID);
                    // give them their options
                    OptionsGUI optionsGUI = new OptionsGUI(user);
                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText(presenter.presentWrongPasswordUsername());
                }
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Creates the SignInGUIMaker
     */

    @Override
    public GUI createGUI() {
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

        return new SignInGUI(frame);
    }
}



