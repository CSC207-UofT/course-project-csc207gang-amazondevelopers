package options.search;


import user.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * the user of the program
 */
public class SearchController {
    User user;

    public SearchController(User user) {
        this.user = user;
    }

    /**
     * Allows the user to input a tag for possible categories of items that they might be interested in,
     * and will receive a list of IDs of those products if the tag exists.
     *
     * @return A list of strings that are toStrings for posts related to that the category,tag of interest.
     */
    public ArrayList<String> getSearchProductStrings(String productTag){
        SearchGateway searchGateway = new SearchGateway();
        // product ID's we want to make to toString
        ArrayList<String> productIdList = searchGateway.searchProducts(productTag);
        // ID to product Hash
        HashMap<String, Object> IdToProduct = searchGateway.searchIDToProductList();

        ArrayList<String> productToString = new ArrayList<>();
        for (String productId : productIdList) {
            int index = productIdList.indexOf(productId);
            String prodIndex = String.valueOf(index);

            if (IdToProduct.containsKey(productId)) {
                Object product = IdToProduct.get(productId);
                String toSt = prodIndex + ") " + product.toString();
                productToString.add(toSt);
            }


        }
        return productToString;

    }

    //get a list containing only the ids of the products as strings
    public ArrayList<String> getProductIDStrings(String productTag){
        SearchGateway searchGateway = new SearchGateway();
        // product ID's we want to make to toString
        ArrayList<String> productIdList = searchGateway.searchProducts(productTag);

        return new ArrayList<>(productIdList);
    }
}

//