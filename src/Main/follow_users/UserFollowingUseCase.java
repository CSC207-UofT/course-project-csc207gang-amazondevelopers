package follow_users;

import PostFunctions.Post;
import UserFunctions.User;
import login.GetUserGateway;
import login.SaveUserGateway;

import java.io.IOException;
import java.util.List;

public class UserFollowingUseCase {
    User user;
    SaveUserGateway saveUserGateway;
    GetUserGateway getUserGateway;

    public UserFollowingUseCase(User user, SaveUserGateway saveUserGateway, GetUserGateway getUserGateway) {
        this.user = user;
        this.saveUserGateway = saveUserGateway;
        this.getUserGateway = getUserGateway;
    }

    /**
     * Method that takes in the String username of the user that this.user wants to follow.
     *
     */
    public void addToFollowingList(String newFollowing) throws IOException, ClassNotFoundException {
        List<String> currentFollowing = this.user.getListFollowing();
        currentFollowing.add(newFollowing);
        // updating list of following of this.user
        this.user.setListFollowing(currentFollowing);
        User userFollower = getUserGateway.getUser(newFollowing);
        List<Post> userFollowerFeed = userFollower.getFeed();
        List<Post> thisUserCurrentFeed = this.user.getFeed();
        // updating feed of this.user
        thisUserCurrentFeed.addAll(userFollowerFeed);
        // updating list of followers of follow user
        List<String> listFollowersFollowUser = userFollower.getListFollowers();
        listFollowersFollowUser.add(this.user.getUsername());

        // save both users to the user.ser file
        saveUserGateway.saveUser(this.user.getUsername(), this.user);
        saveUserGateway.saveUser(newFollowing, userFollower);
    }
}
