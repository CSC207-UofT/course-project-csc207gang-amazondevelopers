package PostFunctions;

import InputAndOutput.SystemInOut;
import ProductFunctions.CreateProductGatewayInterface;
import ProductFunctions.GetProductGatewayInterface;
import ProductFunctions.Product;
import UserFunctions.User;
import java.io.IOException;
import ProductFunctions.Product;
public class PostManager {

    AddPostGatewayInterface addPostGateway;


    public PostManager(AddPostGatewayInterface addPostGateway){
        this.addPostGateway = addPostGateway;
    }

    /**
     * Create a new Post object.
     * This method takes in a Product object for product, a String for the caption, and two booleans
     * to check if comments and ratings can be added.
     * Returns the Post if created and null otherwise.
     *
     * @return a newly created post.
     */
    public Post createPost(Product product, String caption, boolean canComment, boolean canRate,User user)
    throws IOException, ClassNotFoundException {
        return new Post(product, caption, canComment, canRate,user);
    }

    public void savePost(Post newPost, User user) throws IOException, ClassNotFoundException {
        addPostGateway.addPost(newPost, user);
    }

    /**
     * Takes in a Post and adds 1 to likes, representing 1 extra like to the post.
     * @param post the post that the user wants to add a like to.
     */
    public void like(Post post) {
        post.addlike(1);
    }
    /**
     * Takes in a Post and adds a float rating from 0 to 5.
     * @param post the post that the user wants to add a rating to.
     * @param rating the rating user wants to add to post
     * @return returns true if was succesfully rated, false otherwise
     */
    public boolean rate(Post post, float rating) {
        if (post.getCanRate()) {
            post.addRating(rating);
            return true;
        }
        return false;
    }

    /**
     * Takes in a Post and adds a String comment.
     * @param post the post that the user wants to add a comment to.
     * @param comment the comment user wants to add to post
     * @return returns true if was succesfully commented, false otherwise
     */
    public boolean comment(Post post, String comment) {
        if (post.getCanComment()) {
            post.addComment(comment);
            return true;
        }
        return false;
    }
    /**
     * Takes in a Post and sets ability to rate as true or false.
     * @param post the post that the user wants to change rate settings.
     * @param bool true or false for rate settings, can rate or not
     */
    public void changeRateSettings(Post post, boolean bool) {
        post.setCanRate(bool);
    }


    /**
     * Takes in a Post and sets ability to comment as true or false.
     * @param post the post that the user wants to change comment settings.
     * @param bool true or false for comment settings, can rate or not
     */
    public void changeCommentSettings(Post post, boolean bool) {
        post.setCanComment(bool);
    }
    //maybe add methods to check if we can see comments and reviews

    public String postToString(Post post){
        String output = new String();
        output = "Post made by: " + post.getUser().getUsername() +"\n";
        output = output + "Product its about: " + post.getProduct().toString() + "\n";
        output = output + "Caption: " + post.getCaption() + "\n";
        if (post.getCanComment()){
            output = output + "Comments: \n";
            for(int c = 0; c < post.getComments().size(); c++){
                output = output + post.getComments().get(c) + "\n";
            }
        }
        if (post.getCanRate()){
            float ratings = 0;
            for(int c = 0; c < post.getRatings().size(); c++){
                ratings = ratings + post.getRatings().get(c);
            }
            String s = String.valueOf(ratings);
            output = output + "Ratings are: " + s +"\n" ;
        }
        return output;
    }


}
