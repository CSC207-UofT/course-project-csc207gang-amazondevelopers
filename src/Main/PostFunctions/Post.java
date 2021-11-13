package PostFunctions;

import ProductFunctions.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import UserFunctions.User;

public class Post implements Serializable {
    private int likes;
    private Product product;
    private List<Float> ratings;
    private List<String> comments;
    private String description;
    private String caption;
    private boolean canComment;
    private boolean canRate;
    private User user;

    public Post(Product product, String caption, boolean canComment, boolean canRate, User user) {
        this.likes = 0;
        this.product = product;
        this.description = product.toString();
        this.caption = caption;
        this.canRate = canRate;
        this.canComment = canComment;
        this.user = user;
        //these are first empty arraylists
        this.ratings = new ArrayList<Float>();
        this.comments = new ArrayList<String>();
    }

    /**
     * getters and setters for attributes
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }
    public String getCaption() {
        return this.caption;
    }
    public String getProductToString() {
        return product.toString();
    }
    public Product getProduct(){return product;}
    public int getLikes() {
        return likes;
    }
    public void addlike(int likes) {
        this.likes += likes;
    }
    public List<Float> getRatings() {
        return ratings;
    }
    public List<String> getComments() {
        return comments;
    }
    public void addRating(float rating) {
        this.ratings.add(rating);
    }
    public void addComment(String comment) {
        this.comments.add(comment);
    }
    public boolean getCanRate() {
        return canRate;
    }
    public boolean getCanComment() {
        return canComment;
    }
    public void setCanRate(boolean bool) {
        this.canRate = bool;
    }
    public void setCanComment(boolean bool) {
        this.canComment = bool;
    }
    public String getProductDescription() {
        return this.description;
    }
    public User getUser(){return this.user;}
}
