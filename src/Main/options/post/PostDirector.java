package options.post;

import user.User;

/**
 * The director for creating the post
 */
public class PostDirector {

    PostBuilderInterface postBuilderInterface;

    public Post setup(String productId, String caption, boolean canComment, boolean canRate, User user){
        // since we currently only have 1 post builder
            postBuilderInterface = new PostBuilderWithComments();
        return developPost(productId, caption, canComment, canRate, user);
    }


    /**
     * Where the post is created
     * @param productId the ID of the product
     * @param caption the caption of the post
     * @param canComment if other users can comment
     * @param canRate if other users can rate
     * @param user the creater of the post
     * @return the post
     */
    private Post developPost(String productId, String caption, boolean canComment, boolean canRate, User user){
        // we only have 1 type of post builder currently
        // later we would have more post creators


        postBuilderInterface.addCaption(caption);
        postBuilderInterface.addProduct(productId);
        if (canComment) {
            postBuilderInterface.addComment();
        }
        if (canRate) {
            postBuilderInterface.addLikes();
        }
        postBuilderInterface.addUser(user);
        // the built post
        return postBuilderInterface.createPost();

    }
}
//