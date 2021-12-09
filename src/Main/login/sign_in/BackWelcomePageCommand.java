package login.sign_in;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import gui.GeneralGUIMakerInterface;

/**
 * Class that allows the action of going back to the Welcome Page of the program
 */

public class BackWelcomePageCommand implements ButtonCommandInterface {
    GeneralGUIMakerInterface generalGUIMakerInterface;

    /**
     * Constructor for this class
     * @param generalGUIMakerInterface takes in an instance of generalGUIMakerInterface
     */
    public BackWelcomePageCommand(GeneralGUIMakerInterface generalGUIMakerInterface) {
        this.generalGUIMakerInterface = generalGUIMakerInterface;
    }

    /**
     * Method that takes user back to welcome page
     */
    public void apply(){
        generalGUIMakerInterface.disposeFrame();
        GUIFactory guiFactory = new GUIFactory();
        GUIFactoryInterface guiFrame = guiFactory.getFrame("WELCOME");
        guiFrame.createGUI();
    }
}
