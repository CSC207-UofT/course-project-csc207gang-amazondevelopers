package followFunctions;
import inputOutputFunctions.SystemInOut;
import userFunctions.User;
import loginFunctions.GetUserGateway;
import loginFunctions.SaveUserGateway;
import loginFunctions.SaveUserGatewayInterface;
import loginFunctions.SignInGatewayInterface;

import java.io.IOException;

/**
 * User is the signed in user
 */
public class FollowController {

    User user;

    /**
     * Controller to follow another user by the logged in user
     * @param user another user to be followed
     */

    public FollowController(User user) {
        this.user = user;
    }

    /**
     * Allow the user to follow another user.
     *
     */

    public void allowFollow() throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();
        // Ask for the username of the person that this user wants to follow
        EnglishFollowPresenter englishFollowPresenter = new EnglishFollowPresenter(input);
        englishFollowPresenter.presenterToFollow();
        // The username of the user that this user wants to follow
        String userInput = input.getInput();
        if (!userInput.equals("*")) {
//            UserOptionsController userOptions = new UserOptionsController(user);
//            EnglishOptionsPresenter engPresenter = new EnglishOptionsPresenter();
//            userOptions.getOption(input, engPresenter);

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
}

