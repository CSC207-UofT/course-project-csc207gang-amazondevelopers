package login.welcome_page;

import gui.ButtonActionInterface;
import login.sign_up.SignUpGUIMaker;

import java.io.IOException;

public class SignUpButton implements ButtonActionInterface {
    /**
     * When this button is pressed, it Opens the SignUpGUI interface
     */
    public void apply(){
        SignUpGUIMaker signUpGUIMaker = new SignUpGUIMaker();
        signUpGUIMaker.createGUI();
    }
}
