package login;
import InputAndOutput.InOut;
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
    public void userLoginDecision(InOut inOut) throws IOException {
        inOut.sendOutput("What would you like to do? Select the number of choice: \n 1.Signin\n 2.Signup\n 3.Quit\n Input * at anytime to undo your input");
        // user input
        String userDecision = inOut.getInput();

            try {
                if (userDecision.equals("1")) {
                    // sign in
                    SignInController signInCont = new SignInController();
                    String username = signInCont.getUsername(inOut);
                    // the user is directed to option page
                    GetUserGateway signIn = new GetUserGateway();
                    User signedInUser = signIn.getUser(username);
                    UserOptionsController options = new UserOptionsController(signedInUser);
                    options.getOption(inOut);
                    this.userLoginDecision(inOut);


                } else if (userDecision.equals("2")) {
                    SignUpGateway signUp = new SignUpGateway();
                    SignUpUseCase signUpUseCase = new SignUpUseCase(signUp);
                    signUpUseCase.allowSignUp(inOut);
                    // recurse back to login page after sign up to then sign in
                    this.userLoginDecision(inOut);

                } else if (userDecision.equals("3")) {
                    System.exit(0);
                }
                else {
                    inOut.sendOutput("Try again");
                    this.userLoginDecision(inOut);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }





