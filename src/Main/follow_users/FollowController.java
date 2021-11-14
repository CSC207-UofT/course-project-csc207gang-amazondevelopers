package follow_users;

import InputAndOutput.SystemInOut;
import OptionsPackage.UserOptionsController;
import UserFunctions.User;
import login.GetUserGateway;
import login.SaveUserGateway;
import login.SaveUserGatewayInterface;
import login.SignInGatewayInterface;

import java.io.IOException;

public class FollowController {

    User user;

    public FollowController(User user) {
        this.user = user;
    }

    /**
     * Allows the user to input a tag for possible categories of items that they might be interested in and
     * allow user to buy if the list of tags is not empty. If list of tags is empty, then send the user back to
     * choose another option.
     *
     */

    public void allowFollow() throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();
        input.sendOutput("What is the username of the person that you would you like to follow? or " +
                "press * to go back to all options menu");
        String userInput = input.getInput();
        if (userInput.equals("*")){
            UserOptionsController UOC = new UserOptionsController(user);
            UOC.getOption();
        }

        SignInGatewayInterface getUserGateway = new GetUserGateway();
        UserFollowingUseCase userFollowingUseCase = new UserFollowingUseCase(this.user, getUserGateway);
        User userFollowing = userFollowingUseCase.getUser(userInput);
        SaveUserGatewayInterface saveUserGateway = new SaveUserGateway();
        UserFollowingUseCase userFollowingUseCase2 = new UserFollowingUseCase(
                this.user, saveUserGateway);
        userFollowingUseCase2.addToFollowingList(userInput, userFollowing);
    }
}

