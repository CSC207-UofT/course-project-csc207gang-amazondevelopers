package login.welcome_page;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;

import java.io.IOException;

public class SignInCommand implements ButtonCommandInterface {
    public SignInCommand() {
    }

    /**
     * When this button is applied, it opens a new SignInGUI()
     */
    public void apply(){
        GUIFactory guiFactory = new GUIFactory();
        GUIFactoryInterface guiFrame = guiFactory.getFrame("SIGNIN");
        guiFrame.createGUI();
    }
}
