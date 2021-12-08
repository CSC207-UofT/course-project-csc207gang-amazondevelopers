package options.browse.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import options.post.Post;
import user.User;

import javax.swing.*;
import java.util.ArrayList;

public class NextCommand implements ButtonCommandInterface {
    JFrame frame;
    User user;
    ArrayList<Post> feed;
    int index;

    /**
     * Initializer for next command while user is browsing feed
     *
     * @param user user logged in
     * @param frame the frame being operated on
     * @param feed The user's feed
     * @param index the
     */

    public NextCommand(User user, JFrame frame, ArrayList<Post> feed, int index) {
        this.user = user;
        this.frame = frame;
        this.feed = feed;
        this.index = index;
    }

    /**
     * Applies next command feed while user is browsing
     *
     */

    @Override
    public void apply(){
        if (index == feed.size() - 1) {
            frame.setVisible(false);
            frame.dispose();
            GUIFactory guiFactory = new GUIFactory(this.user);
            GUIFactoryInterface guiFrame = guiFactory.getFrame("OPTIONS");
            guiFrame.createGUI();
        } else {
            frame.setVisible(false);
            frame.dispose();
            GUIFactory guiFactory = new GUIFactory(feed, this.user, index + 1);
            GUIFactoryInterface guiFrame = guiFactory.getFrame("FEED");
            guiFrame.createGUI();
        }
    }
}
