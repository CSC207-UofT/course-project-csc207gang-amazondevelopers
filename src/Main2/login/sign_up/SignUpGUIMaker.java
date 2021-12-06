package login.sign_up;


import gui.GUI;
import gui.GUIFactoryInterface;
import login.welcome_page.WelcomePageGUIMaker;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Take user input for signup credentials to sign user up.
 */
public class SignUpGUIMaker implements ActionListener, GUIFactoryInterface {
    SignUpPresenter signUpPresenter = new SignUpPresenter();
    JFrame frame = new JFrame();
    JButton signUpButton = new JButton(signUpPresenter.signUp());
    JButton resetButton = new JButton(signUpPresenter.reset());
    JButton backButton = new JButton(signUpPresenter.back());
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel messageLabel = new JLabel(signUpPresenter.message());
    JLabel userIDLabel = new JLabel(signUpPresenter.userID());
    JLabel userPasswordLabel = new JLabel(signUpPresenter.password());


    /**
     * Constructor is used to set the size of labels and buttons on the page
     */
    public SignUpGUIMaker() throws IOException, ClassNotFoundException {
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
                WelcomePageGUIMaker welcomePageGUIMaker = new WelcomePageGUIMaker();
                welcomePageGUIMaker.createGUI();
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
            SignUpController signUpController = new SignUpController();
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            boolean validIDandPass = signUpController.checkIdAndPass(userID, password);

            boolean existingUsername = false;
            try {
                existingUsername = signUpController.containsUsername(userID);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            if (existingUsername) {
                // taken username
                messageLabel.setForeground(Color.red);
                if (!validIDandPass){
                    // messageLabel.setForeground(Color.red);
                    messageLabel.setText(presenter.message4());
                }
                else {
                    // messageLabel.setForeground(Color.red);
                    messageLabel.setText(presenter.message2());
                }

            }
            // No password
            else if (!validIDandPass) {
                messageLabel.setForeground(Color.red);
                messageLabel.setText(presenter.message4());

            } else { // can sign up
                try {
                    SignUpController.setNewUser(userID, password);
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText(presenter.message3());
                    frame.dispose();
                    WelcomePageGUIMaker welcomePageGUIMaker = new WelcomePageGUIMaker();
                    welcomePageGUIMaker.createGUI();
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }


        }
    }

    /**
     * Creates the SignUpGUIMaker
     */

    @Override
    public GUI createGUI() throws IOException, ClassNotFoundException {
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

        return new SignUpGUI(frame);
    }
}



