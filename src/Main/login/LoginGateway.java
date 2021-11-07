package login;

import InputAndOutput.SystemInOut;
import UserFunctions.User;
import UserFunctions.UserOptionsGateway;

import java.io.IOException;

/**
 * Take user input for what they want to do upon seeing the login page.
 *
 */

public class LoginGateway {


    public void userLoginDecision(SystemInOut inOut) throws IOException {
        inOut.sendOutput("What would you like to do? Select the number of choice: \n 1.Signin\n 2.Signup\n" +
                "3.Quit");

        String userDecision = inOut.getInput();

        try {

            if (userDecision.equals("1")) {
                SignInController signIn = new SignInController();

                inOut.sendOutput("What is your username? (please do not leave this field empty)");
                String username = inOut.getInput();
                User signedInUser = signIn.allowSignIn(username, inOut);
                if (!signedInUser.getUsername().equals("")){
                    // then is is a valid user
                    UserFunctions.UserOptionsGateway options = new UserFunctions.UserOptionsGateway(signedInUser);
                    options.userOptions();
                }
                // otherwise, go back to sign in or sign up page
                this.userLoginDecision(inOut);


            }else if (userDecision.equals("2")) {
                inOut.sendOutput("What would you like to put as your username? " +
                        "(please do not leave this field empty)");
                String newUsername = inOut.getInput();
                if (!newUsername.equals("")){
                    SignUpController signUp = new SignUpController();
                    signUp.allowSignUp(newUsername);
                    // allow user to choose to sign in or sign up


                }else{
                    inOut.sendOutput("invalid username");
                }
                this.userLoginDecision(inOut);


            }else if(userDecision.equals("3")){
                //TODO: how to quit?
                System.exit(0);

            }

            else {
                this.userLoginDecision(inOut);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}




