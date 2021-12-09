package options.post;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import user.User;


/**
 * <likes> is the number of like for the options.post
 * the product that the options.post include
 * rating of the the product our of 5 stars
 * comment for the options.post
 * canCommetn and canRate is decided by the creator of the options.post
 * the user is the logged in user of the program
 *
 */

public class Post implements Serializable, PostInterface {
    private static final long serialVersionUID = 5117426149464800074L;
    private int likes;
    private String product;//The product ID that the post relates to
    private List<Float> ratings;
    private List<String> comments= new ArrayList<>();
    private String caption = "";
    private boolean canComment = false;
    private boolean canRate = false;
    private User user;



    /**
     * The options.post
     * @param product the product being advertised in the options.post
     * @param user the user that created the options.post
     */
    public Post(String product, String caption, boolean canComment, boolean canRate, User user) {
        this.likes = 0;
        this.product = product;
        this.caption = caption;
        this.canRate = canRate;
        this.canComment = canComment;
        this.user = user;
        //these are first empty arraylists
        this.ratings = new ArrayList<>();


    }
    public Post(){

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
    public String getProduct(){return product;}
    public void setProduct(String product){this.product = product;}
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
    public User getUser(){return this.user;}
    public void setUser(User user){this.user = user;}

}
//