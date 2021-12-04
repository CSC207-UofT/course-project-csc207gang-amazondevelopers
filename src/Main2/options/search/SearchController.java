package options.search;

import inputOutputFunctions.InOut;
import options.BuyController;
import options.EnglishOptionsPresenter;
import productFunctions.Product;
import userFunctions.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * the user of the program
 */
public class SearchController {
    User user;

    public SearchController(User user) {
        this.user = user;
    }

//    /**
//     * Allows the user to input a tag for possible categories of items that they might be interested in and
//     * allow user to buy if the list of tags is not empty. If list of tags is empty, then send the user back to
//     * choose another option.
//     *
//     */
//    public void allowSearch(InOut input) throws Exception {
//        List<String> listProductIds = getProductID(input);
//        if (listProductIds.size() != 0){
//            options.BuyController buyController = new BuyController();
//            buyController.allowBuy(input, this.user, listProductIds);
//        }
//        // list of ids is empty, send user back to choose another option
//        else{
//            options.EnglishOptionsPresenter engPresenter = new EnglishOptionsPresenter();
//            engPresenter.noMatchingProductsPresent();
//        }
//    }

    /**
     * Allows the user to input a tag for possible categories of items that they might be interested in,
     * and will receive a list of IDs of those products if the tag exists.
     * @return A list of strings that are toStrings for posts related to that the category,tag of interest.
     *
     */
    public ArrayList<String> getProductID(String productTag) throws IOException, ClassNotFoundException {
        SearchGateway searchGateway = new SearchGateway();
        return searchGateway.searchProducts(productTag);

    }
}

//