package options;

import browseFunctions.BrowseController;
import followFunctions.FollowController;
import inputOutputFunctions.InOut;
import loginFunctions.WelcomePageController;
import product.CreateProductController;
import settingsFunctions.SettingsController;
import userFunctions.SaveUserChangesGateways;
import userFunctions.User;
import java.io.IOException;

/**
 * the user of the program that is logged in
 */
public class UserOptionsController{
    User user;

    public UserOptionsController(User user){
        this.user = user;
    }

    /**
     *
     * @throws IOException error occured during reading a file, when there is an input / output error
     */

    //TODO Controller does not need interface injection: fix for all classes. (delete presenter from the pamaeter)

    public void getOption(InOut input, OptionsPresenterInterface presenter) throws IOException {
        presenter.userOptionsMain();
        String userDecision = input.getInput();
        this.userInput(input, userDecision);
        options.EnglishOptionsPresenter engPresenter = new options.EnglishOptionsPresenter();
        this.getOption(input, engPresenter);
    }

    /**
     * Gives the user the options after the sign in
     * @param userDecision the string decision of what the user wants to do when they are signed in.
     */
    public void userInput(InOut input, String userDecision) {
        try{
            // search and buy
            if(userDecision.equals("1")) {
                // redirects to searchController and returns relevant search info
                options.SearchController searchController = new SearchController(user);
                searchController.allowSearch(input);

                // save the cart of the user
                String username = user.getUsername();
                SaveUserChangesGateways saveUserChangesGateways = new SaveUserChangesGateways();
                saveUserChangesGateways.save(username, user);

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
                browseController.presentFeed(input);
            }
            //setting
            else if (userDecision.equals("5")){
                SettingsController settings = new SettingsController(user);
                settings.getSettingOptions();
            }

            // logout
            else if (userDecision.equals("6")){
                WelcomePageController welcome = new WelcomePageController();
                welcome.userLoginDecision(input);
            }

            else{
                UserOptionsController userOptionsController = new UserOptionsController(user);
                options.EnglishOptionsPresenter engPresenter = new options.EnglishOptionsPresenter();
                userOptionsController.getOption(input, engPresenter);
            }
            // TODO: make exception more specific
        } catch (Exception e) {
            options.EnglishOptionsPresenter presenter = new EnglishOptionsPresenter();
            presenter.genericException();
        }
    }
}
