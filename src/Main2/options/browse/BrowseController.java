package options.browse;
import options.browse.GetUserDictGateway.GetUserDictGateway;
import options.post.Post;
import user.User;

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
    public ArrayList<Post> getFeed() throws IOException, ClassNotFoundException {
        BrowseUseCase browseUseCase = new BrowseUseCase(this.user);
        GetUserDictGateway getUserDictGateway = new GetUserDictGateway();
        HashMap users = getUserDictGateway.getUserDict();
        List<String> following = user.getListFollowing();
        return browseUseCase.generateFeed(users,following);
    }
}
