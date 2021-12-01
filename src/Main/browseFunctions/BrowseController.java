package browseFunctions;
import inputOutputFunctions.SystemInOut;
import optionsPackage.BuyController;
import optionsPackage.EnglishOptionsPresenter;
import optionsPackage.UserOptionsController;
import postFunctions.Post;
import userFunctions.User;
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
    public void presentFeed() throws Exception {
        SystemInOut inOut = new SystemInOut();
        BrowseUseCase browseUseCase = new BrowseUseCase(this.user);
        List<Post> userFeed = browseUseCase.getFeed();
        List<String> feedIds = browseUseCase.getlistIds(userFeed);
        //if the feed of the user is not empty
        if (userFeed.size() != 0){
           BuyController buyController = new BuyController();
           buyController.allowBuy(inOut, this.user, feedIds);
        }
        // user's feed is empty
        else{
            // TODO: instead of calling userOptions print out an error message

            //  dont need to call user options since as soon as this method ends it goes back to user options anyways

            //            UserOptionsController userOptionsController = new UserOptionsController(this.user);
//            EnglishOptionsPresenter engPresenter = new EnglishOptionsPresenter();
//            userOptionsController.getOption(inOut, engPresenter);
        }
    }
}






