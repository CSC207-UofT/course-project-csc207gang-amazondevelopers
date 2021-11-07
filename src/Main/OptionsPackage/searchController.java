package OptionsPackage;

import ProductFunctions.Product;
import ProductFunctions.ProductReadWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * take user input from command line interface and
 * Takes in user input tag words and and returns a list of all products that match that description to the user,
 * taking this information from a the masterManager which accese the tageProduct dictionary in master.
 * That dictionary has keys as the tag words for each product, and a list of product associated with that tag
 * word.
 */

public class searchController{


    public ArrayList<Product> searchProducts(String tag) throws IOException, ClassNotFoundException {
        ProductReadWriter rw = new ProductReadWriter();
        HashMap<String, Object> productSavedDict = rw.readFromFile("product.ser");

        if (productSavedDict.containsKey(tag)){
            return (ArrayList<Product>) productSavedDict.get(tag);
        }
        // if the user does not exist, return a user with an empty username, which the empty username is unaccepted
        // username anyways


        // an empty list since the tag does not exist
        return new ArrayList<>();


    }

    }
