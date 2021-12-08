package options.post;

import user.User;

public interface PostBuilderInterface {

    void addComment();
    void addCaption(String Caption);
    void addProduct(String productID);
    void addUser(User user);
    void addLikes();
    Post createPost();
}
