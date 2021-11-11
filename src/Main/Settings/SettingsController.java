package Settings;

import InputAndOutput.SystemInOut;
import OptionsPackage.BuyController;
import OptionsPackage.UserOptionsController;
import UserFunctions.User;
import UserFunctions.UserReadWriter;
import login.WelcomePageController;

import java.io.IOException;
import java.util.HashMap;

public class SettingsController {
    User user;

    public SettingsController(User user){
        this.user = user;

    }

    public void getSettingOptions(SystemInOut input) throws IOException {

        input.sendOutput("What would you like to do? Input a number for " +
                "your ideal option:\n 1.Delete your account \n 2.change your username \n 3. Edit you products \n" +
                "4. Back to all options");

        String userDecision = input.getInput();

        try{
            if(userDecision.equals("1")) {
                // delete this acocunt


                // delete their products

            }
            else if(userDecision.equals("2")){
                // change username
            }
            else if(userDecision.equals("3")) {
                // a new options gateways to make changes to your products
            }

            else if(userDecision.equals("4")) {
                UserOptionsController options = new UserOptionsController(user);
                options.userInput(input);
            }
            throw new IOException("That is not an accepted input, please try again!");
            // throws exception in case the input is not in the available options of inputs
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    }
    // delete users, reduce quantity


    // delete options
    // 5. Delete your current account
    // delete the user from the .ser file
//    DeleteUserGateway deleter = new DeleteUserGateway(user);
//                deleter.deleteUser(user.getUsername(), input);
    // modify your product quantity
}
