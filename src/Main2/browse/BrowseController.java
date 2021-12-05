package browse;
import browseFunctions.BrowseUseCase;
import browse.GetUserDictGateway.GetUserDictGateway;
import userFunctions.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * user is the user logged into the program
 */
public class BrowseController {
    User user;

    public BrowseController(User user) {
        this.user = user;
    }

    /**
     *
     * Get the feed (list of posts that the users that this user follow have posted) of the user. if feed is not
     * empty, allows user to buy from their feed. If feed is empty, return user back to choose another option.
     *
     */
    public void presentFeed() throws IOException, ClassNotFoundException {
        BrowseUseCase browseUseCase = new BrowseUseCase(this.user);
        GetUserDictGateway getUserDictGateway = new GetUserDictGateway();
        HashMap users = getUserDictGateway.getUserDict();
        List<String> following = user.getListFollowing();
        ArrayList userFeed = browseUseCase.generateFeed(users,following);
        //List<String> feedIds = browseUseCase.getlistProductID(userFeed);
        if (userFeed.size() != 0){
            FeedGUI feedGUI = new FeedGUI(userFeed,user,0);
        }
        else{
            EmptyFeedGUI emptyFeedGUI = new EmptyFeedGUI(user);
        }
    }
}
