package login.welcome_page;

import gui.ButtonCommandInterface;
import login.sign_in.SignInGUIMaker;

public class SignInCommand implements ButtonCommandInterface {
    /**
     * When this button is applied, it opens a new SignInGUI()
     */
    public void apply(){
        SignInGUIMaker signInGUIMaker = new SignInGUIMaker();
        signInGUIMaker.createGUI();
    }
}
