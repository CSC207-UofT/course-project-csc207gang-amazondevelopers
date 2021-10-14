import InputAndOutput.InOut;
import java.io.IOException;

public class createUserController {

    private userManager userManager = new userManager();
    private masterManager masterManager = new masterManager();

    public void userCreator(InOut inOut){
        //ask user to input username
        inOut.sendOutput("Input username:");
        try{
            String username = inOut.getInput();

            inOut.sendOutput("Input password:");
            String password = inOut.getInput();

            inOut.sendOutput("Input profile description:");
            String description = inOut.getInput();

            // need code for getting profile picture
        } catch (IOException e) {
            inOut.sendOutput("An error occurred, try again.");
        }
        // need the code for userManager in order to create a new user. method for creating the user
        // should also return the newly created user so it can be added to the list of users
        // using master manager here

        // need the code for masterManager in order to add the new user to the list of users
        // masterManager.setterUser(username, user);
    }
}
