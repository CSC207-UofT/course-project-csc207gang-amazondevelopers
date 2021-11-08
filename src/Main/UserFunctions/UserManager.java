package UserFunctions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class UserManager {

// TODO redo this class

    // delete user account
    /* returns true if user account has been deleted, false if otherwise*/
    public boolean deactivateAccount(User user) throws IOException, ClassNotFoundException {
        UserReadWriter rw = new UserReadWriter();
        HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
        String username = user.getUsername();

        if (usersSavedDict.containsKey(username)){
            usersSavedDict.remove(username);
            rw.saveToFile("src/Main/user.ser", usersSavedDict);
            return true;
        }
        else {return false;}
    }


    // edit user account
    public void editUserProfile(){
        // edit username
    }

    // keep track of posts


    // change user following list
    public void addToFollowingList(User user, User toFollow){
        List<User> followingList = user.getListFollowing();
        followingList.add(toFollow);



        //        List<User> currentFollowing = user.getListFollowing();
//        currentFollowing.add(newFollowing);
//        user.setListFollowing(currentFollowing);
//
//        // update feed of user
//        List<OptionsPackage.Post> userCurrentFeed = user.getFeed();
//        userCurrentFeed.addAll(newFollowing.getListPosts());
//        user.setFeed(userCurrentFeed);
    }
    // change users cart - add and delete







//
//
//    /**
//     * Creates a new User object.
//     * Method takes in a String for the User's username.
//     * Returns true if user is created and false if user is not created.
//
//     * @param username User's username.
//     * @return true if user is created and false if user not created
//     */
//    public boolean createUser(String username){
//        User newUser = new User(username);
//        // this username does not exist
//        if (checkUsernameStatus(username)){
//            // this username not already in use
//            // Add user to Hashmap that keeps track of all users
//            masterManager.setterUser(username, newUser);
//            return true;
//        }
//        // user not added, username already in use
//        return false;
//    }
//
//    /**
//     * Method that takes in a User and a String representing the new username
//     * and sets it as User's username.
//     * Returns true if username is successfully changed and returns false if
//     * username not changed (already in use by another user)
//     *
//     * @param user User whose username is changed to new username.
//     * @param newUsername User's new username.
//     * @return true if username is successfully changed and returns false if
//     *         username not changed (already in use by another user)
//     */
//    public boolean changeUsername(User user, String newUsername){
//        // if this username is not already in use
//        if (checkUsernameStatus(newUsername)){
//            user.setUsername(newUsername);
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * Method that takes in a String representing a username.
//     * Returns true if username is not taken by another user and returns
//     * false if username is already in use by another user.
//     *
//     * @param username Username whose status is checked.
//     * @return true if username is not taken by another user and returns
//     *         false if username is already in use by another user.
//     */
//
//    private boolean checkUsernameStatus(String username) {
//        return masterManager.getterUser(username).equals(false);
//    }
//
//    /**
//     * Method that takes in a User and OptionsPackage.Post and adds the OptionsPackage.Post to User's list of posts.
//     *
//     * @param postToAdd OptionsPackage.Post to add to user's list of posts.
//     * @param user User whose list of posts postToAdd is added to.
//     */
//    public void addToPostList(OptionsPackage.Post postToAdd, User user){
//        List<OptionsPackage.Post> currentListPosts = user.getListPosts();
//        currentListPosts.add(postToAdd);
//        user.setListPosts(currentListPosts);
//    }
//
//    /**
//     * Method that takes in two Users: The first is a User whose follow list needs to be added to (add a new User)
//     * and the second is a User who is added to the first User's follow list.
//     *
//     * @param user User whose follow list needs to add another User (newFollowing)
//     * @param newFollowing User to add to user's follow list
//     *
//     */
//    public void addToFollowingList(User user, User newFollowing){
//        List<User> currentFollowing = user.getListFollowing();
//        currentFollowing.add(newFollowing);
//        user.setListFollowing(currentFollowing);
//
//        // update feed of user
//        List<OptionsPackage.Post> userCurrentFeed = user.getFeed();
//        userCurrentFeed.addAll(newFollowing.getListPosts());
//        user.setFeed(userCurrentFeed);
//    }
//
//    /**
//     * Method that takes in a User and verifies the User.
//     *
//     * @param user User to be verified
//     */
//    public void verifyUser(User user){
//        user.setVerified(true);
//    }
//
//
//    /**
//     * Method that takes in a User and an int representing the index of the Product in the User's currentSearches.
//     * Add the product at that index to the user's shopping cart.
//     * Return true if product is successfully added to user's shopping cart and false otherwise.
//     *
//     * @param index index of the Product in user's currentSearches list.
//     * @param user User whose shopping cart the product is added to.
//     * @return true if product is successfully added to user's shopping cart and false otherwise.
//     */
//    public boolean addToShoppingCartSearches(int index, User user){
//        List<Product> currentSearchList = user.getCurrentSearches();
//        // index out of bounds
//        if (index >= currentSearchList.size()){
//            return false;
//        }
//        Product productToBuy = currentSearchList.get(index);
//        List<Product> current_cart = user.getShoppingCart();
//        current_cart.add(productToBuy);
//        user.setShoppingCart(current_cart);
//        return true;
//    }
//
//    /**
//     * Method that takes in a User and an int representing the index of the OptionsPackage.Post in the User's
//     * feed.
//     * Add the product in the post at that index to the user's shopping cart.
//     * Return true if product is successfully added to user's shopping cart and false otherwise.
//     *
//     * @param index index of the post of user's feed.
//     * @param user User whose shopping cart the product is added to.
//     * @return true if product is successfully added to user's shopping cart and false otherwise.
//     */
//    public boolean addToShoppingCartFeed(int index, User user){
//        List<OptionsPackage.Post> currentFeed = user.getFeed();
//        // index out of bounds
//        if (index >= currentFeed.size()){
//            return false;
//        }
//        OptionsPackage.Post postAtIndex = currentFeed.get(index);
//        Product productToBuy = postAtIndex.getPost_topic();
//        List<Product> current_cart = user.getShoppingCart();
//        current_cart.add(productToBuy);
//        user.setShoppingCart(current_cart);
//        return true;
//    }
//
//    public List<OptionsPackage.Post> getFeedTotal(User user){
//        return user.getFeed();
//
//    }
}
