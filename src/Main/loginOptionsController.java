import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.Scanner;

public class loginOptionsController {
    SystemInOut inOut = new SystemInOut();

    public boolean userInput() throws IOException {

        try {
            inOut.sendOutput("What would you like to do? Input one of signin or signup or exit");
            String userDecision = inOut.getInput().toLowerCase();
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
                    else{
                        inOut.sendOutput("Something went wrong, rerun the program");
                        return false;
                    }

                case "signup":
                    //
                    createUserController newUserController = new createUserController();
                    newUserController.userCreator(inOut);
                    return true;

                case "exit":
                    return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }
}

// need code for browseController, searchController, and createPostController in order to output
// the correct information



