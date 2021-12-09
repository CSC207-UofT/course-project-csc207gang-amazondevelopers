package login.sign_in;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import gui.GeneralGUIMakerInterface;
import login.welcome_page.WelcomePageGUIMaker;

import java.io.IOException;

public class BackWelcomePageCommand implements ButtonCommandInterface {
    GeneralGUIMakerInterface generalGUIMakerInterface;

    public BackWelcomePageCommand(GeneralGUIMakerInterface generalGUIMakerInterface) {
        this.generalGUIMakerInterface = generalGUIMakerInterface;
    }

    public void apply(){
        generalGUIMakerInterface.disposeFrame();
        GUIFactory guiFactory = new GUIFactory();
        GUIFactoryInterface guiFrame = guiFactory.getFrame("WELCOME");
        guiFrame.createGUI();
    }
}
