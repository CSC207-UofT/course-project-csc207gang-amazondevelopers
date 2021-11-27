package login;
import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;
import OptionsPackage.EnglishOptionsPresenter;
import OptionsPackage.UserOptionsController;
import UserFunctions.User;
import java.io.IOException;

/**
 * Take user input for what they want to do upon seeing the login page.
 *
 */

public class WelcomePageController {

    /**
     * Use case class that decides which classes to call, given the input from the user. Then, calls the methods
     * needed to perform the respective functions.
     */
    public void userLoginDecision(SystemInOut input) throws IOException {
        WelcomePagePresenter presenter = new WelcomePagePresenter();
        String userDecision = presenter.decision(input);

            try {
                if (userDecision.equals("1")) {
                    // sign in
                    SignInController signInCont = new SignInController();
                    String username = signInCont.getUsername();
                    // the user is directed to option page
                    GetUserGateway signIn = new GetUserGateway();
                    User signedInUser = signIn.getUser(username);
                    UserOptionsController options = new UserOptionsController(signedInUser);
                    EnglishOptionsPresenter engPresenter = new EnglishOptionsPresenter();
                    options.getOption(input, engPresenter);
                    this.userLoginDecision(input);


                } else if (userDecision.equals("2")) {
                    SignUpController signUpController = new SignUpController();
                    signUpController.getNewUsername();
                    // recurse back to login page after sign up to then sign in
                    this.userLoginDecision(input);

                } else if (userDecision.equals("3")) {
                    System.exit(0);
                }
                else {
                    input.sendOutput("Try again");
                    this.userLoginDecision(input);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }





