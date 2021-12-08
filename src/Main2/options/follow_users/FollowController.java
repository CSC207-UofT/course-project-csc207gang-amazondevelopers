package options.follow_users;



import login.SaveUserGateway;
import login.GetUserGateway;

import user.User;
import user.UserUseCase;

import java.util.List;

public class FollowController {
    // search for the user
    User user;

    /**
     * Controller to follow another user by the logged in user
     * @param user another user to be followed
     */

    public FollowController(User user) {
        this.user = user;
    }


    /**
     *
     * @param username username of the user that this user wants to follow
     */

    public boolean canFollow(String username){

        GetUserGateway getUserGateway = new GetUserGateway();
        User userToFollow = getUserGateway.getUser(username);
        // that user you want to follow does not exist
        if (userToFollow.getUsername().equals("")){
            return false;
        }
        //Already follow user
        UserUseCase userUseCase = new UserUseCase(this.user);
        List<String> followingList = userUseCase.getFollowingList();
        for (String following: followingList){
            if (username.equals(following)){
                return false;
            }
        }
        // the user you want to follow exists
        userUseCase.userAddToFollow(username);

        // save the user after adding to their following list
        SaveUserGateway saveUserGateway = new SaveUserGateway();
        saveUserGateway.saveUser(this.user.getUsername(), user);

        return true;




        }
    }


