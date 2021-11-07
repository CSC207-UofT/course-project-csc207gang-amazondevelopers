import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.Scanner;

public class loginOptionsController{
    SystemInOut inOut;

    public loginOptionsController(SystemInOut inOut){
        this.inOut = inOut;
    }



    public boolean userInput() throws IOException {
        inOut.sendOutput("What would you like to do? Select the number of choice: \n 1.Signin\n 2.Signup");
        String userDecision = inOut.getInput();
        try{
            switch (userDecision) {
                case "1":
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

// need code for browseController, ProductFunctions.searchController, and PostFunctions.createPostController in order to output
// the correct information


