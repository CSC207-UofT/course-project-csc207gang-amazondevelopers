package user;

import product.Product;

import java.util.List;

public class UserUseCase {
    User user;

    public UserUseCase(User user) {
        this.user = user;

    }

    /**
     * @param usernameToFollow the username of the person you want to follow
     */
    public void userAddToFollow(String usernameToFollow) {
        List<String> listFollowing = user.getListFollowing();
        listFollowing.add(usernameToFollow);
        user.setListFollowing(listFollowing);
    }

    /**
     * @param product product to add to options.cart
     */
    public void userAddToCart(Product product) {
        List<Product> cart = user.getShoppingCart();
        cart.add(product);
        user.setShoppingCart(cart);
    }

    public List<Product> userShoppingCart() {
        //System.out.println(user.getShoppingCart());
            return user.getShoppingCart();
    }

    public List<String> getFollowingList() {
        return user.getListFollowing();
    }
}
