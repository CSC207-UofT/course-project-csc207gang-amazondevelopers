import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.Scanner;

public class loginOptionsController {
    SystemInOut inOut = new SystemInOut();

    public boolean userInput() throws IOException {
        inOut.sendOutput("What would you like to do? Input one of signin or signup");
        String userDecision = inOut.getInput().toLowerCase();
        try{
            switch (userDecision) {
                case "signin":
                    //

                    signInController newSignInController = new signInController();
                    Object existingUser = newSignInController.userSignIn(inOut);
                    if (existingUser instanceof User) {
                        userOptionsController optionsController = new userOptionsController((User) existingUser);
                        optionsController.userInput(inOut);
                        return true;

                    }
                    inOut.sendOutput("Something went wrong");
                    return false;




                case "signup":
                    //
                    createUserController newUserController = new createUserController();
                    newUserController.userCreator(inOut);
                    return true;


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }
}

// need code for browseController, searchController, and createPostController in order to output
// the correct information


