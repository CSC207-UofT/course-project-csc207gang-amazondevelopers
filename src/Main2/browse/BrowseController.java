package browse;
import browseFunctions.BrowseUseCase;
import browseFunctions.EnglishBrowsePresenter;
import browseFunctions.GetUserDictGateway;
import inputOutputFunctions.InOut;
import options.BuyController;
import post.Post;
import userFunctions.User;

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
    public void presentFeed(InOut inOut) throws Exception {
        browseFunctions.BrowseUseCase browseUseCase = new BrowseUseCase(this.user);
        browseFunctions.GetUserDictGateway getUserDictGateway = new GetUserDictGateway();
        browseFunctions.EnglishBrowsePresenter postPresenter = new EnglishBrowsePresenter();
        HashMap users = getUserDictGateway.getUserDict();
        List<String> following = user.getListFollowing();
        ArrayList<Post> userFeed = (ArrayList<Post>) browseUseCase.generateFeed(users,following);
        List<String> feedIds = browseUseCase.getlistProductID(userFeed);
        PostMemento postMemento = new PostMemento();
        postMemento.setState(userFeed.get(0));
        ArrayList<PostMemento.Memento> mementos = new ArrayList<PostMemento.Memento>();
        FeedGUI feedGUI = new FeedGUI(postMemento,userFeed,mementos,user,0);

        if (userFeed.size() != 0){

        }
    }
}
