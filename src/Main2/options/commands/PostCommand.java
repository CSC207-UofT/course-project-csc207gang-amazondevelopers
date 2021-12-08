package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import options.post.PostGUIMaker;
import user.User;

import java.io.IOException;

public class PostCommand implements ButtonCommandInterface {
    User user;
    public PostCommand(User user) {
        this.user = user;
    }

    @Override
    public void apply() throws IOException, ClassNotFoundException {
        GUIFactory guiFactory = new GUIFactory(this.user);
        GUIFactoryInterface guiFrame = guiFactory.getFrame("POST");
        guiFrame.createGUI();
    }
}
