package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;
import UserFunctions.User;
import UserFunctions.CartManager;

import java.io.IOException;
import java.util.List;

public class SearchController {
    /**
     * Allows the user to input a tag for possible categories of items that they might be interested in,
     * and will receive a list of those products if the tag exists.
     * @return A list of strings that are toStrings for posts related to that the category,tage of interest.
     *
     */

    public List<String> allowSearch() throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();
        SearchGateway searchGateway = new SearchGateway();

        input.sendOutput("What is a tag word for your product of interest?.");
        String tagOfInterest = input.getInput();
        return searchGateway.searchProducts(tagOfInterest);

    }
}

