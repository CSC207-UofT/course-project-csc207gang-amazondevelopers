package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;
import UserFunctions.User;
import UserFunctions.CartManager;

import java.io.IOException;
import java.util.List;

public class SearchController {

    public List<String> allowSearch(SystemInOut input) throws IOException, ClassNotFoundException {
        SearchGateway searchController = new SearchGateway();

        input.sendOutput("What is a tag word for your product of interest?.");
        String tagOfInterest = input.getInput();
        return searchController.searchProducts(tagOfInterest);

    }
}

