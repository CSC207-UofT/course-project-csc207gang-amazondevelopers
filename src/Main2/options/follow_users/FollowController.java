package options.follow_users;



import login.SaveUserGateway;
import login.GetUserGateway;

import user.User;
import user.UserUseCase;

import java.io.IOException;

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
     * @throws IOException
     * @throws ClassNotFoundException
     */

    public boolean canFollow(String username) throws IOException, ClassNotFoundException {

        GetUserGateway getUserGateway = new GetUserGateway();
        User userToFollow = getUserGateway.getUser(username);
        // that user you want to follow does not exist
        //TODO: check if I already follow this user
        if (userToFollow.getUsername().equals("")){
            return false;
        }
        // the user you want to follow exists
        UserUseCase userUseCase = new UserUseCase(user);
        userUseCase.userAddToFollow(username);

        // save the user after adding to their following list
        SaveUserGateway saveUserGateway = new SaveUserGateway();
        saveUserGateway.saveUser(this.user.getUsername(), user);

        return true;




        }
    }


