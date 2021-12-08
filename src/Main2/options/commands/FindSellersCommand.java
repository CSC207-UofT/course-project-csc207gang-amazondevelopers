package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import user.User;


public class FindSellersCommand implements ButtonCommandInterface {
    User user;

    /**
     * class initializer
     *
     * @param user user logged in
     */

    public FindSellersCommand(User user) {
        this.user = user;
    }

    /** opens find sellers window
     *
     */

    @Override
    public void apply(){
        GUIFactory guiFactory = new GUIFactory(this.user);
        GUIFactoryInterface guiFrame = guiFactory.getFrame("FOLLOW");
        guiFrame.createGUI();
    }
}
