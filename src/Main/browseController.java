import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class browseController{
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





