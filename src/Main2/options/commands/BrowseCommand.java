package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import options.browse.BrowseController;
import options.browse.FeedGUIMaker;
import options.post.Post;
import user.User;

import java.io.IOException;
import java.util.ArrayList;

public class BrowseCommand implements ButtonCommandInterface {
    User user;
    public BrowseCommand(User user) {
        this.user = user;
    }

    @Override
    public void apply() throws IOException, ClassNotFoundException {
        BrowseController browseController = new BrowseController(user);
        ArrayList<Post> feed = null;
        feed = browseController.getFeed();
        GUIFactory guiFactory = new GUIFactory();
        if (0 == feed.size()){
            GUIFactoryInterface guiFrame = guiFactory.getFrame("EMPTYFEED");
            guiFrame.createGUI();
        }
        else{
            GUIFactoryInterface guiFrame = guiFactory.getFrame("FEED");
            FeedGUIMaker feedGUIMaker = new FeedGUIMaker(feed,user,0);
            guiFrame.createGUI();
        }

    }
}
