package login.sign_up;

import gui.ButtonCommandInterface;
import login.sign_up.SignUpPresenter.EnglishSignUpPresenter;
import login.welcome_page.WelcomePageGUIMaker;

import java.awt.*;

/**
 * Class that allows the action of Signing up to the program
 */
public class SignUpCommand implements ButtonCommandInterface {
    SignUpGUIMaker signUpGUIMaker;

    /**
     * Constructor for this class
     * @param signUpGUIMaker takes in an instance of signUpGUIMaker
     */
    public SignUpCommand(SignUpGUIMaker signUpGUIMaker) {
        this.signUpGUIMaker = signUpGUIMaker;
    }

    /**
     * Method that allows user to sign up and if successful, takes user back to welcome page
     */
    @Override
    public void apply() {
        EnglishSignUpPresenter presenter = new EnglishSignUpPresenter();
        SignUpController signUpController = new SignUpController();
        String userID = signUpGUIMaker.userIDField.getText();
        String password = String.valueOf(signUpGUIMaker.userPasswordField.getPassword());

        boolean validIDandPass = signUpController.checkIdAndPass(userID, password);

        boolean existingUsername;
        existingUsername = signUpController.containsUsername(userID);


        if (existingUsername) {
            // taken username
            signUpGUIMaker.messageLabel.setForeground(Color.red);
            if (!validIDandPass){
                // messageLabel.setForeground(Color.red);
                signUpGUIMaker.messageLabel.setText(presenter.message4());
            }
            else {
                // messageLabel.setForeground(Color.red);
                signUpGUIMaker.messageLabel.setText(presenter.message2());
            }

        }
        // No password
        else if (!validIDandPass) {
            signUpGUIMaker.messageLabel.setForeground(Color.red);
            signUpGUIMaker.messageLabel.setText(presenter.message4());

        } else { // can sign up
            SignUpController.setNewUser(userID, password);
            signUpGUIMaker.messageLabel.setForeground(Color.green);
            signUpGUIMaker.messageLabel.setText(presenter.message3());
            signUpGUIMaker.frame.dispose();
            WelcomePageGUIMaker welcomePageGUIMaker = new WelcomePageGUIMaker();
            welcomePageGUIMaker.createGUI();
        }
    }
}
