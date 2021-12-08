package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import user.User;

import javax.swing.*;
import java.io.IOException;

public class ScrollSearchCommand implements ButtonCommandInterface {
    JFrame frame;
    User user;
    String tag;
    public ScrollSearchCommand(JFrame frame, User user, String tag) {
        this.frame = frame;
        this.user = user;
        this.tag = tag;
    }

    @Override
    public void apply() throws IOException, ClassNotFoundException {
        try {
            GUIFactory guiFactory = new GUIFactory(this.user, this.tag);
            GUIFactoryInterface guiFrame = guiFactory.getFrame("SCROLLSEARCH");
            guiFrame.createGUI();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        frame.dispose();
    }
}
