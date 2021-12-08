package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import user.User;


public class CartCommand implements ButtonCommandInterface {
    User user;
    public CartCommand(User user) {
        this.user = user;
    }

    @Override
    public void apply(){
        GUIFactory guiFactory = new GUIFactory(this.user);
        GUIFactoryInterface guiFrame = guiFactory.getFrame("CART");
        guiFrame.createGUI();
    }
}
