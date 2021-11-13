package login;

import InputAndOutput.SystemInOut;
import OptionsPackage.UserOptionsController;
import UserFunctions.User;
import OptionsPackage.UserOptionsUseCase;

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
        inOut.sendOutput("What would you like to do? Select the number of choice: \n 1.Signin\n 2.Signup\n" +
                "3.Quit\n Input * at any time to undo your action");
        // user input
        String userDecision = inOut.getInput();


            try {
                if (userDecision.equals("1")) {
                    // sign in
                    SignInController signInCont = new SignInController();
                    String username = signInCont.getUsername();
                    // the user is directed to option page
                    SignInGateway signIn = new SignInGateway();
                    User signedInUser = signIn.allowSignIn(username);
                    UserOptionsController options = new UserOptionsController(signedInUser);
                    options.getOption();
                    this.userLoginDecision();


                } else if (userDecision.equals("2")) {
                    SignUpController signUpCont = new SignUpController();
                    String newUsername = signUpCont.getNewUsername();
                    SignUpGateway signUp = new SignUpGateway();
                    signUp.allowSignUp(newUsername);
                    // recurse back to login page after sign up to then sign in
                    this.userLoginDecision();

                } else if (userDecision.equals("3")) {
                    // this.userLoginDecision();
                }
                else {
                    inOut.sendOutput("Try again");

                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }





