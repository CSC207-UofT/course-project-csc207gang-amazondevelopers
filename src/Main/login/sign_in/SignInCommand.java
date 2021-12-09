package login.sign_in;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import login.GetUserGateway;
import login.sign_in.SignInPresenter.EnglishSignInPresenter;
import user.User;
import java.awt.*;

/**
 * Class that allows the action of Signing in to the program
 */
public class SignInCommand implements ButtonCommandInterface {
    SignInGUIMaker signInGUIMaker;

    /**
     * Constructor for this class
     * @param signInGUIMaker takes in an instance of signINGUIMaker
     */
    public SignInCommand(SignInGUIMaker signInGUIMaker) {
        this.signInGUIMaker = signInGUIMaker;
    }

    /**
     * Method that allows user to sign in and if successful, takes user back to options page
     */
    @Override
    public void apply(){
        EnglishSignInPresenter presenter = new EnglishSignInPresenter();
        String userID = signInGUIMaker.userIDField.getText();
        String password = String.valueOf(signInGUIMaker.userPasswordField.getPassword());
        SignInController signInController = new SignInController();
        boolean matchPass = signInController.checkPassMatch(userID, password);
        if (matchPass){
            signInGUIMaker.frame.dispose();
            GetUserGateway getUserGateway = new GetUserGateway();
            User user = getUserGateway.getUser(userID);
            // give them their options
            GUIFactory guiFactory = new GUIFactory(user);
            GUIFactoryInterface guiFrame = guiFactory.getFrame("OPTIONS");
            guiFrame.createGUI();
        } else {
            signInGUIMaker.messageLabel.setForeground(Color.red);
            signInGUIMaker.messageLabel.setText(presenter.presentWrongPasswordUsername());
        }
    }
}
