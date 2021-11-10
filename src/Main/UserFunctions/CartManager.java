package UserFunctions;

import ProductFunctions.Product;

import java.util.List;

/**
 * A use case class that adds items to the user's cart
 */
public class CartManager {

    public void addToCart(Product item, User user){
        List<Product> userCart = user.getShoppingCart();
        userCart.add(item);
    }



}
