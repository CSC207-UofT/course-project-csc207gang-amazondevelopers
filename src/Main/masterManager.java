import java.util.ArrayList;

/**
 * A use case class that accesses and modulated manager entity.
 */
public class masterManager {


    /**
     * A getter of a user from the User dictionary. Which has the username of the user as Strings and the User as the value.
     * @return the userDict
     */
    public static User getterUser(String username){
        return Master.userDict.get(username);
    }

    /**
     * A getter of the products dictionary. Which has the ID of the product of the user as Strings
     * and the Product as the value.
     * @return porductDict
     */
    public static Product getterProduct(String productID){
        return Master.productDict.get(productID);
    }

    /**
     * Inputs a new user in the userDict by modifying the dictionary.
     * @param username  the username of the user
     * @param userProfile  the User associated with the username
     */
    public static void setterUser(String username, User userProfile){
        Master.userDict.put(username, userProfile);
    }


    /**
     * Inputs a new product in the productDict by modifying the dictionary.
     * @param productID   the ID of the product
     * @param item     the item type Product that a User has added to the market.
     */
    public static void setterProduct(String productID, Product item){
        Master.productDict.put(productID, item);

    }

    public static ArrayList<Product> getSearchList(String tagWord) {
        return Master.productTagMap.get(tagWord);
    }
}
