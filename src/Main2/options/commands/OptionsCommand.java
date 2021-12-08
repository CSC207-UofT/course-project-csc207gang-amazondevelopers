package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import user.User;

import javax.swing.*;

public class OptionsCommand implements ButtonCommandInterface {
    JFrame frame;
    User user;

    /**
     * class initializer
     *
     * @param user user logged in
     * @param frame the current frame
     */

    public OptionsCommand(JFrame frame, User user) {
        this.frame = frame;
        this.user = user;
    }

    /**
     * opens options window
     */

    @Override
    public void apply() {
        frame.dispose();
        GUIFactory guiFactory = new GUIFactory(this.user);
        GUIFactoryInterface guiFrame = guiFactory.getFrame("OPTIONS");
        guiFrame.createGUI();
    }
}
