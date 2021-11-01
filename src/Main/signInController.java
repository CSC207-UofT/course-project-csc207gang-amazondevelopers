import InputAndOutput.InOut;
import java.io.IOException;

public class signInController{

    /**
     * Lets user sign into the program.
     *
     * @param inOut an object that implements InOut interface
     * @return
     */

    public Object userSignIn(InOut inOut){
        inOut.sendOutput("Input username:");
        try{
            String username;

            // code to enforce a limit to the length of the username, 20 characters max
            while (true){
                username = inOut.getInput();
                // check if user can be created, if not then username is either too long or has already been taken
                Object result = masterManager.getterUser(username);
                if (result instanceof User){
                    inOut.sendOutput("User profile has been opened.");
                    return result;
                }
                else{
                    inOut.sendOutput("Please input a valid username or rerun the program to signup.");
                }
            }
        } catch (IOException e) {
            inOut.sendOutput("An error occurred, try again.");
            // maybe restart user creation process over again if exception is thrown
        }
        // ideas: give user an option to redo user creation
        return false;
    }
}
