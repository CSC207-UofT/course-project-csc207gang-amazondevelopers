package OptionsPackage;

import UserFunctions.User;

import java.util.List;

public class BrowseUseCase {

    User user;

    public BrowseUseCase(User user) {
        this.user = user;
    }

    /**
     * @return the feed (list of posts that the users that this user follow have posted) of the user.
     */
    public List<Post> getFeed() {
        this.user.getFeed();
    }
}
