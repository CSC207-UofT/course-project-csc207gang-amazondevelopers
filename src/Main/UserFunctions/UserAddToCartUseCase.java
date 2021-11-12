package UserFunctions;

import java.util.ArrayList;
import java.util.List;

public class UserAddToCartUseCase {

//    /**
//     * Method that takes an int representing the index of the Post in the User's feed.
//     * Add the product in the post at that index to the user's shopping cart.
//     * Return true if product is successfully added to user's shopping cart and false otherwise.
//     *
//     * @param index index of the post of user's feed.
//     * @return true if product is successfully added to user's shopping cart and false otherwise.
//     */
//    public boolean addToShoppingCartFeed(int index){
//        List<Post> currentFeed = this.user.getFeed();
//        // index out of bounds
//        if (index >= currentFeed.size()){
//            return false;
//        }
//        Post postAtIndex = currentFeed.get(index);
//        Product productToBuy = postAtIndex.getPost_topic();
//        if (productToBuy.getQuantity() > 0) {
//            List<Product> current_cart = this.user.getShoppingCart();
//            current_cart.add(productToBuy);
//            this.user.setShoppingCart(current_cart);
//            return true;
//        }
//        return false;
//    }
//
//
//    /**
//     * Method that takes an int representing the index of the Product in the User's currentSearches.
//     * Add the product at that index to the user's shopping cart.
//     * Return true if product is successfully added to user's shopping cart and false otherwise.
//     *
//     * @param index index of the Product in user's currentSearches list.
//     * @return true if product is successfully added to user's shopping cart and false otherwise.
//     */
//    public boolean addToShoppingCartSearches(int index, ArrayList<Product> productList){
//        // index out of bounds
//        if (index >= productList.size()){
//            return false;
//        }
//        Product productToBuy = productList.get(index);
//        if (productToBuy.getQuantity() > 0){
//            List<Product> current_cart = this.user.getShoppingCart();
//            current_cart.add(productToBuy);
//            this.user.setShoppingCart(current_cart);
//            return true;
//        }
//        return false;
//    }
//}

