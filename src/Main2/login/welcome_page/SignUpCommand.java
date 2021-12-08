package login.welcome_page;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;

import java.io.IOException;

public class SignUpCommand implements ButtonCommandInterface {
    /**
     * When this button is pressed, it Opens the SignUpGUI interface
     */
    public void apply() throws IOException, ClassNotFoundException {
        GUIFactory guiFactory = new GUIFactory();
        GUIFactoryInterface guiFrame = guiFactory.getFrame("SIGNUP");
        guiFrame.createGUI();
    }
}
