import java.util.ArrayList;
import java.util.List;

public class userManager{
    private User user;

    public userManager(User user) {
        this.user = user;
    }

    /**
     * Method that takes a String representing the new username
     * and sets it as User's username.
     * Returns true if username is successfully changed and returns false if
     * username not changed (already in use by another user)
     *
     * @param newUsername User's new username.
     * @return true if username is successfully changed and returns false if
     *         username not changed (already in use by another user)
     */
    public boolean changeUsername(String newUsername){
        // if this username is not already in use
        if (checkUsernameStatus(newUsername)){
            this.user.setUsername(newUsername);
            return true;
        }
        return false;
    }

    /**
     * Method that takes in a String representing a username.
     * Returns true if username is not taken by another user and returns
     * false if username is already in use by another user.
     *
     * @param username Username whose status is checked.
     * @return true if username is not taken by another user and returns
     *         false if username is already in use by another user.
     */

    private static boolean checkUsernameStatus(String username) {
        return masterManager.getterUser(username).equals(false);
    }

    /**
     * Method that takes in a Post and adds the Post to User's list of posts.
     *
     * @param postToAdd Post to add to user's list of posts.
     */
    public void addToPostList(Post postToAdd){
        List<Post> currentListPosts = this.user.getListPosts();
        currentListPosts.add(postToAdd);
        user.setListPosts(currentListPosts);
    }

    /**
     * Method that takes in a User, who is added to this.user's follow list.
     *
     * @param newFollowing User to add to user's follow list
     *
     */
    public void addToFollowingList(User newFollowing){
        List<User> currentFollowing = this.user.getListFollowing();
        currentFollowing.add(newFollowing);
        this.user.setListFollowing(currentFollowing);

        // update feed of user
        List<Post> userCurrentFeed = this.user.getFeed();
        userCurrentFeed.addAll(newFollowing.getListPosts());
        this.user.setFeed(userCurrentFeed);
    }

    /**
     * Method that verifies the User.
     *
     */
    public void verifyUser(User user){
        this.user.setVerified(true);
    }

    /**
     * Method that takes an int representing the index of the Product in the User's currentSearches.
     * Add the product at that index to the user's shopping cart.
     * Return true if product is successfully added to user's shopping cart and false otherwise.
     *
     * @param index index of the Product in user's currentSearches list.
     * @return true if product is successfully added to user's shopping cart and false otherwise.
     */
    public boolean addToShoppingCartSearches(int index, ArrayList<Product> productList){
        // index out of bounds
        if (index >= productList.size()){
            return false;
        }
        Product productToBuy = productList.get(index);
        if (productToBuy.getQuantity() > 0){
            List<Product> current_cart = this.user.getShoppingCart();
            current_cart.add(productToBuy);
            this.user.setShoppingCart(current_cart);
            return true;
        }
        return false;
    }

    /**
     * Method that takes an int representing the index of the Post in the User's feed.
     * Add the product in the post at that index to the user's shopping cart.
     * Return true if product is successfully added to user's shopping cart and false otherwise.
     *
     * @param index index of the post of user's feed.
     * @return true if product is successfully added to user's shopping cart and false otherwise.
     */
    public boolean addToShoppingCartFeed(int index){
        List<Post> currentFeed = this.user.getFeed();
        // index out of bounds
        if (index >= currentFeed.size()){
            return false;
        }
        Post postAtIndex = currentFeed.get(index);
        Product productToBuy = postAtIndex.getPost_topic();
        if (productToBuy.getQuantity() > 0) {
            List<Product> current_cart = this.user.getShoppingCart();
            current_cart.add(productToBuy);
            this.user.setShoppingCart(current_cart);
            return true;
        }
        return false;
    }

    /**
     * Returns the user's feed.
     *
     * @return The user's feed
     */
    public List<Post> getFeedTotal(){
        return this.user.getFeed();
    }


    /**
     * Empties this user's shopping cart.
     *
     */
    public void emptyShoppingCart(){
        List<Product> currentShoppingCart = this.user.getShoppingCart();
        productManager productManager = new productManager();
        for (Product product : currentShoppingCart){
            productManager.decreaseQuantity(product, 1);
        }
        this.user.setShoppingCart(new ArrayList<>());
    }
}
