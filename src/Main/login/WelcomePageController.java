package login;

import InputAndOutput.SystemInOut;
import UserFunctions.User;
import OptionsPackage.UserOptionsController;

import java.io.IOException;

/**
 * Take user input for what they want to do upon seeing the login page.
 *
 */

public class WelcomePageController {


    public void userLoginDecision(SystemInOut inOut) throws IOException {
        boolean keepRunning = true;
        while(keepRunning) {
        inOut.sendOutput("What would you like to do? Select the number of choice: \n 1.Signin\n 2.Signup\n" +
                "3.Quit\n Input * at any time to undo your action");

        String userDecision = inOut.getInput();
            try {
                if (userDecision.equals("1")) {
                    SignInGateway signInGate = new SignInGateway();
                    String username = signInGate.getUsername(inOut);

                    SignInController signIn = new SignInController();
                    User signedInUser = signIn.allowSignIn(username, inOut);
                    UserOptionsController options = new UserOptionsController(signedInUser);
                    options.userInput(inOut);

                } else if (userDecision.equals("2")) {
                    SignUpGateway signUpGate = new SignUpGateway();
                    String newUsername = signUpGate.getNewUsername(inOut);

                    SignUpController signUp = new SignUpController();
                    signUp.allowSignUp(newUsername);
                    // recurse back to login page after sign up
                    //this.userLoginDecision(inOut);

                } else if (userDecision.equals("3")) {
                    keepRunning = false;
                    //System.exit(0);

                }
                else {
                    inOut.sendOutput("Try again");
                    // this.userLoginDecision(inOut);

                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }
}




