package follow_users;

import InputAndOutput.SystemInOut;
import PostFunctions.Post;
import UserFunctions.User;
import login.GetUserGateway;
import login.GetUserGatewayInterface;
import login.SaveUserGateway;
import login.SaveUserGatewayInterface;

import java.io.IOException;
import java.util.List;

public class UserFollowingUseCase {
    User user;
    SaveUserGateway saveUserGateway;
    GetUserGateway getUserGateway;

    public UserFollowingUseCase(User user, SaveUserGateway saveUserGateway,
                                GetUserGateway getUserGateway) {
        this.user = user;
        this.saveUserGateway = saveUserGateway;
        this.getUserGateway = getUserGateway;
    }
//
//    public UserFollowingUseCase(User user, SaveUserGatewayInterface saveUserGateway) {
//        this.user = user;
//        this.saveUserGateway = saveUserGateway;
//    }
//
//    public UserFollowingUseCase(User user,
//                                GetUserGatewayInterface getUserGateway) {
//        this.user = user;
//        this.getUserGateway = getUserGateway;
//    }

    /**
     * Method that takes in the String username of the user that this.user wants to follow.
     *
     */
    public void addToFollowingList(String newFollowing) throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();
        List<String> currentFollowing = this.user.getListFollowing();
        currentFollowing.add(newFollowing);
        // updating list of following of this.user
        this.user.setListFollowing(currentFollowing);
        User userFollower = getUserGateway.getUser(newFollowing);
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
        saveUserGateway.saveUser(user, this.user.getUsername(), this.user);
        saveUserGateway.saveUser(user, newFollowing, userFollower);
        input.sendOutput("The user was followed successfully.");

    }
}
