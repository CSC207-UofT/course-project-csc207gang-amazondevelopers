package options.browse;
import options.browse.GetUserDictGateway.GetUserDictGateway;
import options.post.Post;
import user.User;
import user.UserUseCase;

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
     */
    public ArrayList<Post> getFeed(){
        BrowseUseCase browseUseCase = new BrowseUseCase(this.user);
        GetUserDictGateway getUserDictGateway = new GetUserDictGateway();
        HashMap users = getUserDictGateway.getUserDict();
        UserUseCase userUseCase = new UserUseCase(this.user);
        List<String> following = userUseCase.getFollowingList();
        return browseUseCase.generateFeed(users,following);
    }
}
