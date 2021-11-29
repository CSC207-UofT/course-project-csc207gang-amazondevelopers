import inputOutputFunctions.SystemInOut;
import java.io.IOException;


public class loginOptionsController{
    SystemInOut inOut = new SystemInOut();

    /**
     * Gives user option to either signin or signup. Return true if signin or signup were
     * successful and false otherwise.
     *
     * @throws IOException throws exception if wrong string is inputted
     * @return true if user is able to sign in or sign up and false otherwise
     */

    public boolean userInput() throws IOException {
        inOut.sendOutput("What would you like to do? Input one of signin or signup");
        String userDecision = inOut.getInput().toLowerCase();
        try{
            switch (userDecision) {
                case "signin":
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


