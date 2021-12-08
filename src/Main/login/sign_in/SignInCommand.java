package login.sign_in;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import login.GetUserGateway;
import login.sign_in.SignInPresenter.EnglishSignInPresenter;
import user.User;
import java.awt.*;

public class SignInCommand implements ButtonCommandInterface {
    SignInGUIMaker signInGUIMaker;

    public SignInCommand(SignInGUIMaker signInGUIMaker) {
        this.signInGUIMaker = signInGUIMaker;
    }

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
