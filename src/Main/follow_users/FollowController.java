package follow_users;
import InputAndOutput.SystemInOut;
import OptionsPackage.EnglishOptionsPresenter;
import OptionsPackage.UserOptionsController;
import UserFunctions.User;
import login.GetUserGateway;
import login.SaveUserGateway;
import login.SaveUserGatewayInterface;
import login.SignInGatewayInterface;

import java.io.IOException;

/**
 * User is the signed in user
 */
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
        EnglishFollowPresenter englishFollowPresenter = new EnglishFollowPresenter(input);
        englishFollowPresenter.presenterToFollow();


        String userInput = input.getInput();
        if (userInput.equals("*")){
            UserOptionsController UOC = new UserOptionsController(user);
            EnglishOptionsPresenter engPresenter = new EnglishOptionsPresenter();
            UOC.getOption(input, engPresenter);
        }

        SignInGatewayInterface getUserGateway = new GetUserGateway();
        UserFollowingUseCase userFollowingUseCase = new UserFollowingUseCase(this.user, getUserGateway);
        User userFollowing = userFollowingUseCase.getUser(userInput);
        SaveUserGatewayInterface saveUserGateway = new SaveUserGateway();
        UserFollowingUseCase userFollowingUseCase2 = new UserFollowingUseCase(
                this.user, saveUserGateway);
        EnglishFollowPresenter followPresenter1 = new EnglishFollowPresenter(input);
        userFollowingUseCase2.addToFollowingList(userInput, userFollowing, followPresenter1);
    }
}

