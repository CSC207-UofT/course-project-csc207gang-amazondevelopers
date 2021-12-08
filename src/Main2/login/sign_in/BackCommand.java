package login.sign_in;

import gui.ButtonCommandInterface;
import gui.GeneralGUIInterface;
import login.welcome_page.WelcomePageGUIMaker;

public class BackCommand implements ButtonCommandInterface {
    GeneralGUIInterface generalGUIInterface;

    public BackCommand(GeneralGUIInterface generalGUIInterface) {
        this.generalGUIInterface = generalGUIInterface;
    }

    public void apply(){
        generalGUIInterface.disposeFrame();
        WelcomePageGUIMaker welcomePageGUIMaker = new WelcomePageGUIMaker();
        welcomePageGUIMaker.createGUI();
    }
}
