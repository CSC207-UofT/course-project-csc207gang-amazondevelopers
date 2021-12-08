package options.post;
import login.SaveUserGateway;
import login.SaveUserGatewayInterface;
import product.CreateProductController;
import product.Product;
import user.User;

import java.util.ArrayList;

/**
 * Controller that takes care of all the actions needed to create a options.post.
 */

public class CreatePostController {

    User user;

    public CreatePostController(User user) {
        this.user = user;
    }

    /**
     * Method that takes in an arraylist of all the information needed to create
     * a options.post. Creates the options.post and adds it to this.user's listofPosts.
     * @param information a list of all the information needed to create a options.post
     */
    public void createPost(ArrayList<String> information){
        // creating the product to add to the options.post
        CreateProductController createProductController = new CreateProductController(this.user);
        Product product = createProductController.createProduct(information);

        SaveUserGatewayInterface saveUserGateway = new SaveUserGateway();
        PostManager postManager = new PostManager(saveUserGateway);
        // need to get this attributes
        boolean canComment = Boolean.parseBoolean(information.get(7));
        boolean canRate = Boolean.parseBoolean(information.get(6));
        Post newPost = postManager.createPostWithRateComment(product.getId(), information.get(4), canComment, canRate, this.user);
        // add options.post to user's list of posts
        postManager.savePost(newPost, this.user);
    }
}