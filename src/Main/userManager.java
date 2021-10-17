import java.util.ArrayList;
import java.util.List;

public class userManager{

    /**
     * Creates a new User object.
     * Method takes in a String for the User's username.
     * Returns true if user is created and false if user is not created.

     * @param username User's username.
     * @return true if user is created and false if user not created
     */
    public static boolean createUser(String username){
        User newUser = new User(username);
        // this username does not exist
        if (checkUsernameStatus(username)){
            // this username not already in use
            // Add user to Hashmap that keeps track of all users
            masterManager.setterUser(username, newUser);
            return true;
        }
        // user not added, username already in use
        return false;
    }

    /**
     * Method that takes in a User and a String representing the new username
     * and sets it as User's username.
     * Returns true if username is successfully changed and returns false if
     * username not changed (already in use by another user)
     *
     * @param user User whose username is changed to new username.
     * @param newUsername User's new username.
     * @return true if username is successfully changed and returns false if
     *         username not changed (already in use by another user)
     */
    public boolean changeUsername(User user, String newUsername){
        // if this username is not already in use
        if (checkUsernameStatus(newUsername)){
            user.setUsername(newUsername);
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
     * Method that takes in a User and Post and adds the Post to User's list of posts.
     *
     * @param postToAdd Post to add to user's list of posts.
     * @param user User whose list of posts postToAdd is added to.
     */
    public void addToPostList(Post postToAdd, User user){
        List<Post> currentListPosts = user.getListPosts();
        currentListPosts.add(postToAdd);
        user.setListPosts(currentListPosts);
    }

    /**
     * Method that takes in two Users: The first is a User whose follow list needs to be added to (add a new User)
     * and the second is a User who is added to the first User's follow list.
     *
     * @param user User whose follow list needs to add another User (newFollowing)
     * @param newFollowing User to add to user's follow list
     *
     */
    public void addToFollowingList(User user, User newFollowing){
        List<User> currentFollowing = user.getListFollowing();
        currentFollowing.add(newFollowing);
        user.setListFollowing(currentFollowing);

        // update feed of user
        List<Post> userCurrentFeed = user.getFeed();
        userCurrentFeed.addAll(newFollowing.getListPosts());
        user.setFeed(userCurrentFeed);
    }

    /**
     * Method that takes in a User and verifies the User.
     *
     * @param user User to be verified
     */
    public void verifyUser(User user){
        user.setVerified(true);
    }


    /**
     * Method that takes in a User and an int representing the index of the Product in the User's currentSearches.
     * Add the product at that index to the user's shopping cart.
     * Return true if product is successfully added to user's shopping cart and false otherwise.
     *
     * @param index index of the Product in user's currentSearches list.
     * @param user User whose shopping cart the product is added to.
     * @return true if product is successfully added to user's shopping cart and false otherwise.
     */
    public static boolean addToShoppingCartSearches(int index, User user, ArrayList<Product> productList){
        // index out of bounds
        if (index >= productList.size()){
            return false;
        }
        Product productToBuy = productList.get(index);
        List<Product> current_cart = user.getShoppingCart();
        current_cart.add(productToBuy);
        user.setShoppingCart(current_cart);
        return true;
    }

    /**
     * Method that takes in a User and an int representing the index of the Post in the User's
     * feed.
     * Add the product in the post at that index to the user's shopping cart.
     * Return true if product is successfully added to user's shopping cart and false otherwise.
     *
     * @param index index of the post of user's feed.
     * @param user User whose shopping cart the product is added to.
     * @return true if product is successfully added to user's shopping cart and false otherwise.
     */
    public static boolean addToShoppingCartFeed(int index, User user){
        List<Post> currentFeed = user.getFeed();
        // index out of bounds
        if (index >= currentFeed.size()){
            return false;
        }
        Post postAtIndex = currentFeed.get(index);
        Product productToBuy = postAtIndex.getPost_topic();
        List<Product> current_cart = user.getShoppingCart();
        current_cart.add(productToBuy);
        user.setShoppingCart(current_cart);
        return true;
    }

    public List<Post> getFeedTotal(User user){
        return user.getFeed();

    }
}
