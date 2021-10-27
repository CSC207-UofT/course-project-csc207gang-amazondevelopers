import InputAndOutput.SystemInOut;
import java.io.IOException;
import java.util.Objects;

public class userOptionsController{
    User user;

    /**
     * Creates a userOptionsController object.
     * Takes in a User.
     *
     * @param user A user object.
     */
    public userOptionsController(User user){
        this.user = user;
    }

    /**
     * Gives user four options: Search, Post, Browse or Buy Cart.
     *
     * @param input an object that implements InOut interface
     * @throws IOException
     */
    public void userInput(SystemInOut input) throws IOException {

        try{
            input.sendOutput("What would you like to do? Input one of Search, Post, Browse, Buy Cart");
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
                else if (Objects.equals(userDecision, "search"))  {
                    // redirects to searchController and returns relevant search info
                    searchController searchController = new searchController();
                    searchController.searchProducts(input, this.user);
                }
                else{ //(Objects.equals(userDecision, "Buy Cart"))
                    userManager userManager = new userManager(this.user);
                    userManager.emptyShoppingCart();
                    input.sendOutput("Shopping cart is empty.");
                }
                // TODO: handle else case (should have an error displayed when something other than these four options are entered)
            // throw new IOException("That is not an accepted input, please try again!");
            // throws exception in case the input is not in the available options of inputs
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}