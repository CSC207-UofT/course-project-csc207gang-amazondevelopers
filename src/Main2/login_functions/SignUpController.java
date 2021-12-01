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
public class SignUpController implements ActionListener {
    SignUpPresenter signUpPresenter = new SignUpPresenter();
    JFrame frame = new JFrame();
    JButton signUpButton = new JButton("Sign Up");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Back");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel messageLabel = new JLabel(signUpPresenter.message());
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPasswordLabel = new JLabel("password: ");

    GetIDandPasswords getIDandPasswords = new GetIDandPasswords();
    HashMap<String, Object> loginInfo = getIDandPasswords.getUsernamePasswordHash();



    /**
     * Constructor is used to set the size of labels and buttons on the page
     */
    public SignUpController() throws IOException, ClassNotFoundException {


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
     *
     * @param e The action event, helps to maintain the actions performed by the user and the results from their
     *          actions that they perform on the page
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        SignInPresenter presenter = new SignInPresenter();
        if(e.getSource()==backButton) {
            frame.dispose();
            try {
                WelcomePageController welcomePageController = new WelcomePageController();
                //TODO: edit try catch
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if(e.getSource()== signUpButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(loginInfo.containsKey(userID)) {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("This username is taken!");
            }
            else {
                SetIDandPasswords setNewUser = new SetIDandPasswords();

                // Put the new user into the hashmap
                try {
                    setNewUser.setUsernamePasswordHash(userID, password);
                    SaveUserGateway saveUser = new SaveUserGateway();
                    // save the new user
                    //TODO: check is it's ok to send user as a parameter in controller
                    saveUser.saveUser(userID, new User(userID));
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                frame.dispose();
                // Go back to welcome page
                try {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Success!");
                    WelcomePageController welcomePageController = new WelcomePageController();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }

        }

    }
}
