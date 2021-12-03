package login_functions;

import userFunctions.User;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

/**
 * Take user input for signup credentials to sign user up.
 */
public class SignUpGUI implements ActionListener {
    SignUpPresenter signUpPresenter = new SignUpPresenter();
    JFrame frame = new JFrame();
    //TODO Put the bottom texts into presenters
    JButton signUpButton = new JButton("Sign Up");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Back");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel messageLabel = new JLabel(signUpPresenter.message());
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPasswordLabel = new JLabel("password: ");


    /**
     * Constructor is used to set the size of labels and buttons on the page
     */
    public SignUpGUI() throws IOException, ClassNotFoundException {


        userIDLabel.setBounds(50, 150, 75, 25);
        userPasswordLabel.setBounds(50, 200, 75, 25);

        messageLabel.setBounds(125, 100, 250, 35);
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

    }

    /**
     * @param e The action event, helps to maintain the actions performed by the user and the results from their
     *          actions that they perform on the page
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        SignUpPresenter presenter = new SignUpPresenter();
        if (e.getSource() == backButton) {
            frame.dispose();
            try {
                WelcomePageGUI welcomePageGUI = new WelcomePageGUI();
                //TODO: edit try catch
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if (e.getSource() == signUpButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            SignUpController signUpController = new SignUpController();
            boolean existingUsername = false;
            try {
                existingUsername = signUpController.containsUsername(userID);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            if (existingUsername) {
                // taken username
                messageLabel.setForeground(Color.red);
                messageLabel.setText(presenter.message2());

            }
            // No password
            else if (password.equals("") | userID.equals("")) {
                messageLabel.setForeground(Color.red);
                messageLabel.setText(presenter.message4());

            } else { // can sign up
                try {
                    SignUpController.setNewUser(userID, password);
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText(presenter.message3());
                    frame.dispose();
                    WelcomePageGUI welcomePageGUI = new WelcomePageGUI();
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }


        }
    }
}



