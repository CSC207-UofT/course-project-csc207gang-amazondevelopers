package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;
import UserFunctions.User;
import UserFunctions.CartManager;

import java.io.IOException;
import java.util.List;

public class SearchController {
    User user;

    public SearchController(User user) {
        this.user = user;
    }

    /**
     * Allows the user to input a tag for possible categories of items that they might be interested in and
     * allow user to buy if the list of tags is not empty. If list of tags is empty, then send the user back to
     * choose another option.
     *
     */

    public void allowSearch() throws IOException, ClassNotFoundException {
        List<String> listProductIds = getProductID();
        if (listProductIds.size() != 0){
            BuyController buyController = new BuyController();
            buyController.allowBuy(this.user, listProductIds);
        }
        // list of ids is empty, send user back to choose another option
        else{
            UserOptionsController userOptionsController = new UserOptionsController(this.user);
            userOptionsController.getOption();
        }
    }

    /**
     * Allows the user to input a tag for possible categories of items that they might be interested in,
     * and will receive a list of IDs of those products if the tag exists.
     * @return A list of strings that are toStrings for posts related to that the category,tag of interest.
     *
     */
    private List<String> getProductID() throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();
        SearchGateway searchGateway = new SearchGateway();

        input.sendOutput("What is a tag word for your product of interest?.");
        String tagOfInterest = input.getInput();
        return searchGateway.searchProducts(tagOfInterest);
    }
}

