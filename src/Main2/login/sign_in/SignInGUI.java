package login.sign_in;

import gui.GUI;

import javax.swing.*;

/**
 * Base GUI for SigninGUIMaker to implement.
 */
public class SignInGUI implements GUI {
    JFrame frame;
    public SignInGUI(JFrame frame) {
        this.frame = frame;
    }
}
