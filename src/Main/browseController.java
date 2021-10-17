import InputAndOutput.InOut;
import java.util.List;

public class browseController{

    /**
     * Takes in a User and an object that implements inOut and passes the User's
     * feed to the cart Controller so that User can buy from their feed.
     *
     * @param inOut an object that implements InOut interface
     * @param user A User object
     */

    public void searchFeed(InOut inOut, User user){
        userManager userManager = new userManager();
        List<Post> PostList = userManager.getFeedTotal(user);
        inOut.sendOutput(PostList);
        if (!PostList.isEmpty()) {
            cartController cart = new cartController();
            cart.addToCartFeed(inOut, user);
        } else {
            inOut.sendOutput("There was an error. You are not currently following anyone.");
        }
    }
}





