package follow_users;
import InputAndOutput.SystemInOut;
import PostFunctions.Post;
import UserFunctions.User;
import login.SaveUserGatewayInterface;
import login.SignInGatewayInterface;
import java.io.IOException;
import java.util.List;

/**
 * User is the signed in user
 */
public class UserFollowingUseCase {
    User user;
    SaveUserGatewayInterface saveUserGatewayInterface;
    SignInGatewayInterface getUserGatewayInterface;

    public UserFollowingUseCase(User user, SaveUserGatewayInterface saveUserGateway) {
        this.user = user;
        this.saveUserGatewayInterface = saveUserGateway;
    }

    public UserFollowingUseCase(User user, SignInGatewayInterface getUserGateway) {
        this.user = user;
        this.getUserGatewayInterface = getUserGateway;
    }

    /**
     * Method that takes in the String username of the user that this.user wants to follow and makes the user
     * a follower of this.user.
     *
     */
    public void addToFollowingList(String newFollowing, User userFollower, FollowPresenterInterface presenter) throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();
        List<String> currentFollowing = this.user.getListFollowing();
        currentFollowing.add(newFollowing);
        // updating list of following of this.user
        this.user.setListFollowing(currentFollowing);
        List<Post> userFollowerPost = userFollower.getListPosts();
        List<Post> thisUserCurrentFeed = this.user.getFeed();
        if (userFollowerPost.size() != 0) {
            // updating feed of this.user
            thisUserCurrentFeed.addAll(userFollowerPost);
            this.user.setFeed(thisUserCurrentFeed);
        }
        // updating list of followers of follow user
        List<String> listFollowersFollowUser = userFollower.getListFollowers();
        listFollowersFollowUser.add(this.user.getUsername());
        userFollower.setListFollowers(listFollowersFollowUser);

        // save both users to the user.ser file
        saveUserGatewayInterface.saveUser(this.user.getUsername(), user);
        saveUserGatewayInterface.saveUser(newFollowing, userFollower);
        presenter.presenterFollowed();

    }

    /**
     * Method that takes in the String username of the user that this.user wants to follow and returns
     * its type User.
     * @return User associated with the String username being passed in.
     */
    public User getUser(String newFollowing) throws IOException, ClassNotFoundException {
        // TODO: fix this
        return getUserGatewayInterface.getUser(newFollowing);
    }


}
