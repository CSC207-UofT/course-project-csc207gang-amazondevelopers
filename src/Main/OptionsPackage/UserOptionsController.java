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

public class UserOptionsController{
    User user;

    public UserOptionsController(User user){
        this.user = user;
    }

    /**
     *
     * @throws IOException error occured during reading a file, when there is an input / output error
     */
    public void getOption() throws IOException {
        SystemInOut input = new SystemInOut();
        input.sendOutput("What would you like to do? Input a number for " +
                "your ideal option:\n 1.Search and buy \n 2.Make a post \n 3.Follow another user \n 4.Browse and buy" +
                "\n 5.Settings \n 6.logout ");
        String userDecision = input.getInput();
        this.userInput(userDecision);
        this.getOption();
    }

    /**
     * Gives the user the options after the sign in
     * @param userDecision the string decision of what the user wants to do when they are signed in.
     */
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
                BrowseController browseController = new BrowseController(user);
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

            else{
                UserOptionsController userOptionsController = new UserOptionsController(user);
                userOptionsController.getOption();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
