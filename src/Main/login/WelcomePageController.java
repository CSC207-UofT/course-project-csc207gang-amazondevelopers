package login;
import InputAndOutput.SystemInOut;
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
    public void userLoginDecision() throws IOException {
        SystemInOut inOut = new SystemInOut();
        inOut.sendOutput("What would you like to do? Select the number of choice: \n 1.Signin\n 2.Signup\n 3.Quit");
        // user input
        String userDecision = inOut.getInput();


            try {
                if (userDecision.equals("1")) {
                    // sign in
                    SignInController signInCont = new SignInController();
                    String username = signInCont.getUsername();
                    // the user is directed to option page
                    GetUserGateway signIn = new GetUserGateway();
                    User signedInUser = signIn.getUser(username);
                    UserOptionsController options = new UserOptionsController(signedInUser);
                    options.getOption();
                    this.userLoginDecision();


                } else if (userDecision.equals("2")) {
                    SignUpController signUpController = new SignUpController();
                    signUpController.getNewUsername();
                    // recurse back to login page after sign up to then sign in
                    this.userLoginDecision();

                } else if (userDecision.equals("3")) {
                    System.exit(0);
                }
                else {
                    inOut.sendOutput("Try again");
                    this.userLoginDecision();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }





