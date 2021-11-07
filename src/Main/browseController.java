import InputAndOutput.InOut;
import UserFunctions.cartController;
import UserFunctions.userManager;

import java.util.List;

public class browseController{
    public void searchFeed(InOut inOut, User user){
        userManager userManager = new userManager();
        List<Post> PostList = userManager.getFeedTotal(user);
        if (!PostList.isEmpty()) {
            cartController cart = new cartController();
            cart.addToCartFeed(inOut, user);

        } else {
            inOut.sendOutput("There was an error, please restart the program");

        }


    }

    }





