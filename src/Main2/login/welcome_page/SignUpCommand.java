package login.welcome_page;

import gui.ButtonCommandInterface;
import login.sign_up.SignUpGUIMaker;

public class SignUpCommand implements ButtonCommandInterface {
    /**
     * When this button is pressed, it Opens the SignUpGUI interface
     */
    public void apply(){
        SignUpGUIMaker signUpGUIMaker = new SignUpGUIMaker();
        signUpGUIMaker.createGUI();
    }
}
