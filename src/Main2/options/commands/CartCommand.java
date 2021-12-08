package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import user.User;

import java.io.IOException;

public class CartCommand implements ButtonCommandInterface {
    User user;
    public CartCommand(User user) {
        this.user = user;
    }

    @Override
    public void apply() throws IOException, ClassNotFoundException {
        GUIFactory guiFactory = new GUIFactory(this.user);
        GUIFactoryInterface guiFrame = guiFactory.getFrame("CART");
        guiFrame.createGUI();
    }
}
