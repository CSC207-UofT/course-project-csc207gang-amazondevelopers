package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;
import UserFunctions.User;
import UserFunctions.CartManager;

import java.io.IOException;
import java.util.List;

public class SearchGateway {

    public List<Product> allowSearch(SystemInOut input) throws IOException, ClassNotFoundException {
        SearchController searchController = new SearchController();

        input.sendOutput("What is a tag word for your product of interest?");
        String tagOfInterest = input.getInput();
        return searchController.searchProducts(tagOfInterest);

    }


    }

