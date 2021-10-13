import java.util.ArrayList;
import java.util.List;

public class User {

    // variables
    private String username;
    private boolean isVerified;
    private List<Post> listPosts;
    private List<User> listFollowing;
    private List<Product> shoppingCart;
    private List<Product> currentSearches;

    /**
     * Creates a new User object.
     * This constructor takes in  arguments, a String for the Bag's colour and
     * an int for the Bag's capacity.
     *
     * @param username this user's username.
     */

    public User(String username){
        this.username = username;
        this.isVerified = false;
        this.listPosts = new ArrayList<>();
        this.shoppingCart = new ArrayList<>();
        this.currentSearches = new ArrayList<>();
    } //
}
