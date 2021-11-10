package OptionsPackage;

import InputAndOutput.SystemInOut;

import UserFunctions.User;
import UserFunctions.UserReadWriter;

import java.io.IOException;
import java.util.HashMap;


// right now, we can only search and buy and add products.
// TODO we will later impelement browse and post

public class UserOptionsController {
    User user;

    public UserOptionsController(User user){
        this.user = user;
    }

    public void userInput(SystemInOut input) throws IOException {

        input.sendOutput("What would you like to do? Input a number for " +
                "your ideal option:\n 1.Search and buy \n 2.Make a post \n 3.Follow another user \n 4.Browse and buy");
        String userDecision = input.getInput();


        try{
            if(userDecision.equals("1")) {
                // redirects to OptionsPackage.searchController and returns relevant search info
                SearchController searchGate = new SearchController();
                searchGate.allowBuy(input, user);

               // searchGate.allowBuy(input, user);
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
            }
            else if(userDecision.equals("4")){
                // this user wants to browse posts of the users it is following
                // redirects to OptionsPackage.browseController and return feed
                // OptionsPackage.browseController OptionsPackage.browseController = new OptionsPackage.browseController();
                // OptionsPackage.browseController.searchFeed(input, this.user);
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
