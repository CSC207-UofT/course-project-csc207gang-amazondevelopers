package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import user.User;

import java.io.IOException;

public class FindSellersCommand implements ButtonCommandInterface {
    User user;
    public FindSellersCommand(User user) {
        this.user = user;
    }

    @Override
    public void apply() throws IOException, ClassNotFoundException {
        GUIFactory guiFactory = new GUIFactory(this.user);
        GUIFactoryInterface guiFrame = guiFactory.getFrame("FOLLOW");
        guiFrame.createGUI();
    }
}
