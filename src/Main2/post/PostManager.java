package post;
import login_functions.SaveUserGatewayInterface;
import user.User;

import java.io.IOException;

/**
 * The use case class to manage and create posts
 */
public class PostManager {

    SaveUserGatewayInterface saveUserGateway;

    /**
     *
     * @param saveUserGateway To adhere to dependency inversion, this is the gateway to save the post to user.ser file
     */

    public PostManager(SaveUserGatewayInterface saveUserGateway){
        this.saveUserGateway = saveUserGateway;
    }

    /**
     * Create a new Post object.
     * This method takes in a Product object for product, a String for the caption, and two booleans
     * to check if comments and ratings can be added.
     * Returns the Post if created and null otherwise.
     *
     * @return a newly created post.
     */
    public Post createPost(productFunctions.Product product, String caption, boolean canComment, boolean canRate, User user) {
        return new Post(product, caption, canComment, canRate, user);
    }

    public void savePost(Post newPost, User user) throws IOException, ClassNotFoundException {
        user.addToPostList(newPost);
        // gateway saves overwrite the old user
        saveUserGateway.saveUser(user.getUsername(), user);
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
        StringBuilder output;
        output = new StringBuilder("Post made by: " + post.getUser().getUsername() + "\n");
        output.append("Product its about: ").append(post.getProduct().toString()).append("\n");
        output.append("Caption: ").append(post.getCaption()).append("\n");
        if (post.getCanComment()){
            output.append("Comments: \n");
            for(int c = 0; c < post.getComments().size(); c++){
                output.append(post.getComments().get(c)).append("\n");
            }
        }
        if (post.getCanRate()){
            float ratings = 0;
            for(int c = 0; c < post.getRatings().size(); c++){
                ratings = ratings + post.getRatings().get(c);
            }
            String s = String.valueOf(ratings);
            output.append("Ratings are: ").append(s).append("\n");
        }
        return output.toString();
    }


}