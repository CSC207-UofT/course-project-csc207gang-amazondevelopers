package login_functions;

import options.OptionsGUI;
import user.User;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Take user input for signin credentials to sign user in.
 */
public class SignInGUI implements ActionListener {
    SignInPresenter signInPresenter = new SignInPresenter();
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Back");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel messageLabel = new JLabel(signInPresenter.message());
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPasswordLabel = new JLabel("password: ");


    /**
     * Constructor is used to set the size of labels and buttons on the page
     */
    public SignInGUI() throws IOException, ClassNotFoundException {


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

    }
    /**
     *
     * @param action The action event, helps to maintain the actions performed by the user and the results from their
     *          actions that they perform on the page
     */
    @Override
    public void actionPerformed(ActionEvent action) {
        SignInPresenter presenter = new SignInPresenter();
        if(action.getSource()==backButton) {
            frame.dispose();
            try {
                WelcomePageGUI welcomePageGUI = new WelcomePageGUI();
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
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText(presenter.message3());
                    frame.dispose();
                    User user = SignInController.getUser(userID);
                    // give them their options
                    OptionsGUI optionsGUI = new OptionsGUI(user);
                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText(presenter.message4());
                }
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}



