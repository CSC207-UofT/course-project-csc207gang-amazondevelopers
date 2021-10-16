import InputAndOutput.InOut;
import java.io.IOException;
/**
 * A controller class that creates a new user, and adds this user to the list of all users.
 */
// javadoc needs work
public class createUserController {

    private userManager userManager = new userManager();
    private masterManager masterManager = new masterManager();

    /**
     * Takes user input for a username, password, and profile description for a new user profile.
     */
    public void userCreator(InOut inOut){
        inOut.sendOutput("Input username (must be less than 20 characters):");
        try{
            boolean validUsername = false;
            String username = "";

            // code to enforce a limit to the length of the username, 20 characters max
            while (!validUsername){
                username = inOut.getInput();
                // check if user can be created, if not then username is either too long or has already been taken
                if (username.length() <= 20 && userManager.createUser(username)){
                    validUsername = true;
                    inOut.sendOutput("User profile successfully created.");
                    // print out username for the user to look over
                    inOut.sendOutput("Username: " + username);
                }
                else if (username.length() > 20){
                    inOut.sendOutput("Username is too long. Try again.");
                }
                else{
                    inOut.sendOutput("Username has already been taken. Try again.");
                }
            }

            /* This code will be uncommented later, will not be included in skeleton
            inOut.sendOutput("Input password:");
            String password = inOut.getInput();

            inOut.sendOutput("Input profile description:");
            // should also try and enforce a limit to the # of characters in the description
            String description = inOut.getInput();

            // need code to get user profile picture
            */

        } catch (IOException e) {
            inOut.sendOutput("An error occurred, try again.");
            // maybe restart user creation process over again if exception is thrown
        }
        // ideas: give user an option to redo user creation


    }
}
