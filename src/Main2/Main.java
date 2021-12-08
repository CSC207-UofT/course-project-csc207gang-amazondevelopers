import gui.GUIFactory;
import gui.GUIFactoryInterface;
import login.welcome_page.WelcomePageGUIMaker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        GUIFactory guiFactory = new GUIFactory();
        GUIFactoryInterface guiFrame = guiFactory.getFrame("WELCOME");
        guiFrame.createGUI();
    }
}
