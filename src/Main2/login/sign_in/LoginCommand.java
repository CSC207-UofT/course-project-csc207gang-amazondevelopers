package login.sign_in;

import gui.ButtonCommandInterface;
import login.GetUserGateway;
import login.sign_in.SignInPresenter.EnglishSignInPresenter;
import options.OptionsGUI;
import user.User;
import java.awt.*;

public class LoginCommand implements ButtonCommandInterface {
    SignInGUIMaker signInGUIMaker;

    public LoginCommand(SignInGUIMaker signInGUIMaker) {
        this.signInGUIMaker = signInGUIMaker;
    }

    @Override
    public void apply() {
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
            OptionsGUI optionsGUI = new OptionsGUI(user);
        } else {
            signInGUIMaker.messageLabel.setForeground(Color.red);
            signInGUIMaker.messageLabel.setText(presenter.presentWrongPasswordUsername());
        }
    }
}
