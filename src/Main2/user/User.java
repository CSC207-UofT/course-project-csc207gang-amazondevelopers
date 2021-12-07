package user;

import options.post.Post;
import product.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    // instance variables
    private static final long serialVersionUID = 7132054135933010940L;
    private String username;
    private List<Post> listPosts;
    private List<Product> shoppingCart;
    private List<String> listFollowing; // people we follow
    public String password;
    private List<String> listFollowers; // people that follow me

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
        this.listFollowing = new ArrayList<>();
        this.listFollowers = new ArrayList<>();
    }

    public String getPassword() {return this.password;}

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getListFollowers(){
        return listFollowers;
    }
    // getter for instance variable username
    public String getUsername() {
        return username;
    }

    // setter for instance variable username
    public void setUsername(String username) {
        this.username = username;
    }

    public void addToCart(Product product){this.shoppingCart.add(product);}

    // getter for list posts
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

    public void setShoppingCart(List<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    // getter for instance variable listFollowing
    public List<String> getListFollowing() {
        return listFollowing;
    }

    // setter for instance variable listFollowing
    public void setListFollowing(List<String> listFollowing) {
        this.listFollowing = listFollowing;
    }
    public void addToPostList(Post post){
        this.listPosts.add(post);
    }
    public void setListFollowers(List<String> listFollowers) {
        this.listFollowers = listFollowers;
    }
}
