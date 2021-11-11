package OptionsPackage;
import InputAndOutput.SystemInOut;
import UserFunctions.User;
import java.io.IOException;
import java.util.List;

public class BrowseController {
    User user;

    public BrowseController(User user) {
        this.user = user;
    }

    /**
     *
     * @return presents the feed (list of posts that the users that this user follow have posted) of the user. if feed is not
     * empty, allows user to buy from their feed.
     *
     */
    public void presentFeed() throws IOException, ClassNotFoundException {
        BrowseUseCase browseUseCase = new BrowseUseCase(this.user);
        List<Post> userFeed = browseUseCase.getFeed();
        SystemInOut systemInOut = new SystemInOut();
        systemInOut.sendOutput(userFeed);
        //if the feed of the user is not empty
        if (userFeed.size() != 0){
           BuyController buyController = new BuyController();
           buyController.allowBuy(systemInOut, this.user);
        }
    }
}






