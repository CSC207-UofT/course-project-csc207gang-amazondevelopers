import InputAndOutput.InOut;

import java.io.IOException;
import java.util.ArrayList;

/**
 * take user input from command line interface and
 * Takes in user input tag words and and returns a list of all products that match that description to the user,
 * taking this information from a the masterManager which accese the tageProduct dictionary in master.
 * That dictionary has keys as the tag words for each product, and a list of product associated with that tag
 * word.
 */

public class searchController{

    public void searchProducts(InOut inOut, User user){
        String tagWord;

        inOut.sendOutput("Search by tag: ");
        try {
            tagWord = inOut.getInput();
            boolean validTag = false;
            // code to enforce a limit to the length of the username, 20 characters max
            while (!validTag) {
                    // get the list of products matching the tag word
                    ArrayList<Product> productList = masterManager.getSearchList(tagWord);
                    inOut.sendOutput(productList);
                    if (!productList.isEmpty()) {
                        cartController cart = new cartController();
                        // where do we get the current users information from
                        cart.addToCartSearch(inOut, user, productList);
                        validTag = true;

                    } else {
                        inOut.sendOutput("There are no products matching that tag. Search for a new tag: ");
                        tagWord = inOut.getInput();
                    }

            }


            }catch(IOException e){
                inOut.sendOutput("An error occurred, try again.");
            }

               }


    }
