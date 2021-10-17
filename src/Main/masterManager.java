import java.util.ArrayList;

/**
 * A use case class that accesses and modulated manager entity.
 */
public class masterManager {


    /**
     * A getter of a user from the User dictionary. Which has the username of the user as Strings and the User as the value.
     * If the username exit in the dictionary, return the user, othermwise, return a string indicating that the
     * user does not exist.
     * If the object does not exist, return false, and the command line interface will give a message that
     * the product does not exist.
     * @return the userDict
     */
    public static Object getterUser(String username){
        if (Master.userDict.containsKey(username)){
            return Master.userDict.get(username);
        }else{
            return false;
        }

    }

    /**
     * A getter of the products dictionary. Which has the ID of the product of the user as Strings
     * and the Product as the value.If the id exit in the dictionary, return the product, othermwise,
     * return a string indicating that the product does not exist.
     * If the object does not exist, return false, and the command line interface will give a message that
     * the product does not exist.
     * @return porductDict
     */
    public static Object getterProduct(String productID){
        if(Master.productDict.containsKey(productID)) {
            return Master.productDict.get(productID);
        }else{
            return false;
        }
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

    public static Object getSearchList(String tagWord) {
        if (Master.productTagMap.containsKey(tagWord)){
        return Master.productTagMap.get(tagWord);}
        else{
            return false;
        }
    }



}


