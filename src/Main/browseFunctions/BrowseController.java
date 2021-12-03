package browseFunctions;
import inputOutputFunctions.InOut;
import options.BuyController;
import postFunctions.Post;
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
        BrowseUseCase browseUseCase = new BrowseUseCase(this.user);
        GetUserDictGateway getUserDictGateway = new GetUserDictGateway();
        EnglishBrowsePresenter postPresenter = new EnglishBrowsePresenter();
        HashMap users = getUserDictGateway.getUserDict();
        List<String> following = user.getListFollowing();
        List<Post> userFeed = browseUseCase.generateFeed(users,following);
        List<String> feedIds = browseUseCase.getlistProductID((ArrayList<Post>) userFeed);
        for (Post post : userFeed){
            postPresenter.presentSinglePost(post);
        }
        if (userFeed.size() != 0){
            postPresenter.presentProduct();
           BuyController buyController = new BuyController();
           buyController.allowBuy(inOut, this.user, feedIds);
        }
    }
}






