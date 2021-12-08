package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import user.User;

import javax.swing.*;

public class SearchCommand implements ButtonCommandInterface {
    JFrame frame;
    User user;

    /**
     * class initializer
     *
     * @param frame current frame
     * @param user user currently logged
     */

    public SearchCommand(JFrame frame, User user) {
        this.frame = frame;
        this.user = user;
    }

    /**
     * creates search window
     */

    @Override
    public void apply(){
        frame.dispose();
        GUIFactory guiFactory = new GUIFactory(this.user);
        GUIFactoryInterface guiFrame = guiFactory.getFrame("SEARCH");
        guiFrame.createGUI();
    }
}
