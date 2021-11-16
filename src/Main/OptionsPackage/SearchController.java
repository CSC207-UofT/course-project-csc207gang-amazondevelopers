package OptionsPackage;
import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;
import UserFunctions.User;
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
    public void allowSearch(InOut input) throws Exception {
        List<String> listProductIds = getProductID(input);
        if (listProductIds.size() != 0){
            BuyController buyController = new BuyController();
            buyController.allowBuy(input, this.user, listProductIds);
        }
        // list of ids is empty, send user back to choose another option
        else{
            // TODO: tell user that there are no products matching the tag and let them search again
            input.sendOutput("There are no products matching that tag word. Try again.");
            UserOptionsController userOptionsController = new UserOptionsController(this.user);
            userOptionsController.getOption(input);
        }
    }

    /**
     * Allows the user to input a tag for possible categories of items that they might be interested in,
     * and will receive a list of IDs of those products if the tag exists.
     * @return A list of strings that are toStrings for posts related to that the category,tag of interest.
     *
     */
    private List<String> getProductID(InOut input) throws Exception, ClassNotFoundException {
        SearchGateway searchGateway = new SearchGateway();

        input.sendOutput("What is a tag word for your product of interest?.");
        String tagOfInterest = input.getInput();
        if (tagOfInterest.equals("*")){
            throw new Exception();
        }
        else {
            return searchGateway.searchProducts(tagOfInterest);
        }
    }
}

