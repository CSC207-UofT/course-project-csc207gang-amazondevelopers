package login.welcome_page;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;

public class SignUpCommand implements ButtonCommandInterface {
    /**
     * When this button is pressed, it Opens the SignUpGUI interface
     */
    public void apply(){
        GUIFactory guiFactory = new GUIFactory();
        GUIFactoryInterface guiFrame = guiFactory.getFrame("SIGNUP");
        guiFrame.createGUI();
    }
}
