package options.browse;
import options.browse.GetUserDictGateway.GetUserDictGateway;
import options.post.Post;
import user.User;
import user.UserUseCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * user is the user logged into the program
 */
public class BrowseController {
    User user;

    /**Initializes browse controller
     *
     * @param user the user
     */

    public BrowseController(User user) {
        this.user = user;
    }

    /** Gets the feed of the user
     *
     * @return browse use case
     */

    public ArrayList<Post> getFeed(){
        BrowseUseCase browseUseCase = new BrowseUseCase(this.user);
        GetUserDictGateway getUserDictGateway = new GetUserDictGateway();
        HashMap<String,Object> users = getUserDictGateway.getUserDict();
        UserUseCase userUseCase = new UserUseCase(this.user);
        List<String> following = userUseCase.getFollowingList();
        return browseUseCase.generateFeed(users,following);
    }
}