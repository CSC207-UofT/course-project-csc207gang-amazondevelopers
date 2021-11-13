package OptionsPackage;

import Browse.BrowseController;
import InputAndOutput.SystemInOut;

import ProductFunctions.CreateProductController;
import Settings.SettingsController;
import UserFunctions.User;
import UserFunctions.UserReadWriter;
import follow_users.FollowController;
import login.WelcomePageController;

import java.io.IOException;
import java.util.HashMap;


public class UserOptionsUseCase {
    User user;

    public UserOptionsUseCase(User user){
        this.user = user;
    }

    // TODO: too long method!

    public void userInput(String userDecision) {
        SystemInOut input = new SystemInOut();
        try{
            // search and buy
            if(userDecision.equals("1")) {
                // redirects to searchController and returns relevant search info
                SearchController searchController = new SearchController(user);
                searchController.allowSearch();

                // save the cart of the user
                // TODO Phase2: separate into gateway
                String username = user.getUsername();
                UserReadWriter rw = new UserReadWriter();
                HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
                usersSavedDict.put(username, user);
                rw.saveToFile("src/Main/user.ser", usersSavedDict);

            }
            // make a post
            else if(userDecision.equals("2")){
                // create the product,
                CreateProductController productC = new CreateProductController();
                productC.createNewProductFromInput(input, user);
                // then add it as a post
            }
            // follow
            else if(userDecision.equals("3")){
                // this user wants to follow another user.
                // this user needs to enter the username of the user they want to follow
                // This user then needs to be added to this user's follow list
                FollowController followC = new FollowController(user);
                followC.allowFollow();
            }
            // browse
            else if(userDecision.equals("4")){
                // this user wants to browse posts of the users it is following
                BrowseController browseController = new BrowseController(this.user);
                browseController.presentFeed();
            }
            //setting
            else if (userDecision.equals("5")){
                SettingsController settings = new SettingsController(user);
                settings.getSettingOptions();
            }
            // logout

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
