package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import user.User;


public class CartCommand implements ButtonCommandInterface {
    User user;

    /**
     * class initializer
     *
     * @param user user logged in
     */

    public CartCommand(User user) {
        this.user = user;
    }

    /** opens user cart window
     *
     */

    @Override
    public void apply(){
        GUIFactory guiFactory = new GUIFactory(this.user);
        GUIFactoryInterface guiFrame = guiFactory.getFrame("CART");
        guiFrame.createGUI();
    }
}
