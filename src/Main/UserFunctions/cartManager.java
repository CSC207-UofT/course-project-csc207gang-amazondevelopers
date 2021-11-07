package UserFunctions;

import InputAndOutput.InOut;
import ProductFunctions.Product;
import UserFunctions.userManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A use case class that adds items to the user's cart
 */
public class cartManager {

    public void addToCart(Product item, User user){
        List<Product> userCart = user.getShoppingCart();
        userCart.add(item);

    }



}
