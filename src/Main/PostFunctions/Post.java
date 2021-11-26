package PostFunctions;
import ProductFunctions.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import UserFunctions.User;

/**
 * <likes> is the number of like for the post
 * the product that the post include
 * rating of the the product our of 5 stars
 * comment for the post
 * canCommetn and canRate is decided by the creator of the post
 * the user is the logged in user of the program
 *
 */
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


    /**
     * The post
     * @param product the product being advertised in the post
     * @param caption the caption that the user puts for the post
     * @param canComment the choice from the post creater to comment on the post
     * @param canRate the choice from the post creater to give a rate on the post
     * @param user the user that created the post
     */
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
