import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.Scanner;

public class loginOptionsController {
    SystemInOut inOut = new SystemInOut();

    public void userInput() throws IOException {
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

                    }
                    inOut.sendOutput("Something went wrong, rerun the program");




                case "signup":
                    //
                    createUserController newUserController = new createUserController();
                    newUserController.userCreator(inOut);


                }
                throw new IOException("That is not an accepted input, please try again!");
                // throws exception in case the input is not in the available options of inputs
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

// need code for browseController, searchController, and createPostController in order to output
// the correct information



