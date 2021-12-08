package options.browse.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import options.post.Post;
import user.User;

import javax.swing.*;
import java.util.ArrayList;

public class BackCommand implements ButtonCommandInterface {
    JFrame frame;
    User user;
    ArrayList<Post> feed;
    int index;

    /**
     * Initializer for Back command while user is browsing feed
     *
     * @param user user logged in
     * @param frame the frame being operated on
     * @param feed The user's feed
     * @param index the
     */

    public BackCommand(User user, JFrame frame, ArrayList<Post> feed, int index) {
        this.user = user;
        this.frame = frame;
        this.feed = feed;
        this.index = index;
    }

    /**Goes back one item in user browse window
     *
     */

    @Override
    public void apply(){
        if (this.index == 0) {
            frame.setVisible(false);
            frame.dispose();
            GUIFactory guiFactory = new GUIFactory(this.user);
            GUIFactoryInterface guiFrame = guiFactory.getFrame("OPTIONS");
            guiFrame.createGUI();
        } else {
            frame.setVisible(false);
            frame.dispose();
            GUIFactory guiFactory = new GUIFactory( feed, user, index - 1);
            GUIFactoryInterface guiFrame = guiFactory.getFrame("FEED");
            guiFrame.createGUI();
        }
    }
}
