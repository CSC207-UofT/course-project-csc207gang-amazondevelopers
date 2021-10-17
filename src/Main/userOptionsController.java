import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.Objects;

public class userOptionsController{
    User user;

    public userOptionsController(User user){
        this.user = user;
    }

    public void userInput(SystemInOut input) throws IOException {

        try{
            input.sendOutput("What would you like to do? Input one of Search, Post, Browse");
            String userDecision = input.getInput().toLowerCase();
                if (Objects.equals(userDecision, "post")) {
                    // redirects to createPostController class
                    createPostController postController = new createPostController();
                    postController.postCreator(input, this.user);
                }
                else if(Objects.equals(userDecision, "browse")) {
                    // redirects to browseController and return feed
                    browseController browseController = new browseController();
                    browseController.searchFeed(input, this.user);
                }
                else {// (Objects.equals(userDecision, "search"))  {
                    // redirects to searchController and returns relevant search info
                    searchController searchController = new searchController();
                    searchController.searchProducts(input, this.user);
                }
                // TODO: handle else case
            // throw new IOException("That is not an accepted input, please try again!");
            // throws exception in case the input is not in the available options of inputs
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// need code for browseController, searchController, and createPostController in order to output
// the correct information