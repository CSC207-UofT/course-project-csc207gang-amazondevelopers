package OptionsPackage;

import ProductFunctions.Product;
import ProductFunctions.ProductReadWriter;
import UserFunctions.UserReadWriter;

import java.io.File;
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

public class SearchGateway {

    public ArrayList<String> searchProducts(String tag) throws IOException, ClassNotFoundException {

        File file = new File("src/Main/product.ser");
        if (file.length() == 0){
            UserReadWriter rw = new UserReadWriter();
            HashMap<String, Object> emptyHashMap = new HashMap<>();
            rw.saveToFile("src/Main/product.ser", emptyHashMap);
        }

        ProductReadWriter rw = new ProductReadWriter();
        HashMap<String, Object> productSavedDict = rw.readFromFile("src/Main/product.ser");

        if (productSavedDict.containsKey(tag)){
            return (ArrayList<String>) productSavedDict.get(tag);
        }
        // if the user does not exist, return a user with an empty username, which the empty username is unaccepted
        // username anyways


        // an empty list since the tag does not exist
        return new ArrayList<>();


    }

    }
