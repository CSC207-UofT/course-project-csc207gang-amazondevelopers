package options.post;

import user.User;

public class PostBuilderWithComments implements PostBuilderInterface{
    Post post = new Post();

    /**
     * This is used to add a comment
     */
    @Override
    public void addComment() { this.post.addComment("");

    }

    /**
     * Used to set the caption of the post
     * @param caption the caption the user wants on a post
     */
    @Override
    public void addCaption(String caption) { this.post.setCaption(caption);

    }

    /**
     * Used to set the product id of the post
     * @param productID the unique identifier of the post
     */
    @Override
    public void addProduct(String productID) { this.post.setProduct(productID);

    }

    /**
     * Adding a user object
     * @param user the user object itself
     */
    @Override
    public void addUser(User user) { this.post.setUser(user);

    }

    /**
     * add a like to the post
     */
    @Override
    public void addLikes() {
        this.post.addlike(0);
    }

    /**
     *
     * @return the Post object created
     */
    public Post createPost(){
        return this.post;

    }
}
//