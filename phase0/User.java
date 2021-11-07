import java.util.ArrayList;
import java.util.List;

public class User{

    // instance variables
    private String username;
    private List<Post> listPosts;
    private List<Product> shoppingCart;
    private List<Product> currentSearches;
    private List<User> listFollowing;
    private List<Post> feed;
    private boolean isVerified;

    /**
     * Creates a new User object.
     * This constructor takes in 1 argument, a string username.
     * The User is not verified when created. Other User attributes are set
     * as empty Arraylists.
     *
     * @param username this user's username.
     */
    public User(String username){
        this.username = username;
        this.listPosts = new ArrayList<>();
        this.shoppingCart = new ArrayList<>();
        this.currentSearches = new ArrayList<>();
        this.listFollowing = new ArrayList<>();
        this.feed = new ArrayList<>();
        this.isVerified = false;
    }

    // getter for instance variable username
    public String getUsername() {
        return username;
    }

    // setter for instance variable username
    public void setUsername(String username) {
        this.username = username;
    }

    // getter for instance variable listPosts
    public List<Post> getListPosts() {
        return listPosts;
    }

    // setter for instance variable listPosts
    public void setListPosts(List<Post> listPosts) {
        this.listPosts = listPosts;
    }

    // getter for instance variable shoppingCart
    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    // setter for instance variable shoppingCart
    public void setShoppingCart(List<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    // getter for instance variable currentSearches
    public List<Product> getCurrentSearches() {
        return currentSearches;
    }

    // setter for instance variable currentSearches
    public void setCurrentSearches(List<Product> currentSearches) {
        this.currentSearches = currentSearches;
    }

    // getter for instance variable listFollowing
    public List<User> getListFollowing() {
        return listFollowing;
    }

    // setter for instance variable listFollowing
    public void setListFollowing(List<User> listFollowing) {
        this.listFollowing = listFollowing;
    }

    // getter for instance variable feed
    public List<Post> getFeed() {
        return feed;
    }

    //setter for instance variable feed
    public void setFeed(List<Post> feed) {
        this.feed = feed;
    }

    // getter for instance variable isVerified
    public boolean isVerified() {
        return isVerified;
    }

    // setter for instance variable isVerified
    public void setVerified(boolean verified) {
        isVerified = verified;
    }

}
