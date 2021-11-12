package OptionsPackage;

import InputAndOutput.SystemInOut;

import Settings.SettingsController;
import UserFunctions.SaveUserChangesGatewaysInterface;
import UserFunctions.User;
import UserFunctions.UserReadWriter;
import login.WelcomePageController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UserOptionsUseCase {
    User user;

    public UserOptionsUseCase(User user){
        this.user = user;
    }

    public void userInput(String userDecision) {
        SystemInOut input = new SystemInOut();
        try{
            if(userDecision.equals("1")) {
                // redirects to searchController and returns relevant search info
                SearchController searchController = new SearchController(user);
                searchController.allowSearch();

                // save the cart of the user
                String username = user.getUsername();
                UserReadWriter rw = new UserReadWriter();
                HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
                usersSavedDict.put(username, user);
                rw.saveToFile("src/Main/user.ser", usersSavedDict);
                // TODO separate into gateway
            }
            else if(userDecision.equals("2")){
                // create the product,
                // TODO then add it as a post
            }
            else if(userDecision.equals("3")){
                // this user wants to follow another user.
                // this user needs to enter the username of the user they want to follow
                // This user then needs to be added to this user's follow list
                input.sendOutput("What is the username of the person you would like to follow?");
                String usernameToFollow = input.getInput();
                UserFunctions.FollowGateway following = new UserFunctions.FollowGateway(user);
                following.follow(usernameToFollow, input);

            }
            else if(userDecision.equals("4")){
                // this user wants to browse posts of the users it is following
                BrowseController browseController = new BrowseController(this.user);
                browseController.presentFeed();
            }
            else if (userDecision.equals("5")){
                SettingsController settings = new SettingsController(user);
                settings.getSettingOptions();
            }

            else if (userDecision.equals("6")){
                WelcomePageController welcome = new WelcomePageController();
                welcome.userLoginDecision();
            }

//  implement allowing the user to browse, and create a post
//            }else if(userDecision == "2"){
//                // redirects to PostFunctions.createPostController class
//                createPostController postController = new createPostController();
//                postController.postCreator(input, this.user);

            throw new IOException("That is not an accepted input, please try again!");
            // throws exception in case the input is not in the available options of inputs
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
