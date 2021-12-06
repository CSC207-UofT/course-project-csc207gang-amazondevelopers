package login.welcome_page;

import gui.ButtonActionInterface;
import login.sign_in.SignInGUIMaker;

import java.io.IOException;

public class SignInButton implements ButtonActionInterface {
    public void apply() throws IOException, ClassNotFoundException {
        SignInGUIMaker signInGUIMaker = new SignInGUIMaker();
        signInGUIMaker.createGUI();
    }
}
