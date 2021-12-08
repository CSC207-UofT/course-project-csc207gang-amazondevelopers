package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import options.browse.BrowseController;
import options.post.Post;
import user.User;

import java.util.ArrayList;

public class BrowseCommand implements ButtonCommandInterface {
    User user;
    public BrowseCommand(User user) {
        this.user = user;
    }

    @Override
    public void apply(){
        BrowseController browseController = new BrowseController(this.user);
        ArrayList<Post> feed = browseController.getFeed();
        if (0 == feed.size()){
            GUIFactory guiFactory = new GUIFactory(this.user);
            GUIFactoryInterface guiFrame = guiFactory.getFrame("EMPTYFEED");
            guiFrame.createGUI();
        }
        else{
            GUIFactory guiFactory = new GUIFactory(feed,this.user,0);
            GUIFactoryInterface guiFrame = guiFactory.getFrame("FEED");
            guiFrame.createGUI();
        }

    }
}
