package options.post;

import user.User;

public class PostBuilderWithComments implements PostBuilderInterface{
    Post post = new Post();


    @Override
    public void addComment() { post.addComment("");

    }

    @Override
    public void addCaption(String caption) { post.setCaption(caption);

    }

    @Override
    public void addProduct(String productID) { post.setProduct(productID);

    }

    @Override
    public void addUser(User user) { post.setUser(user);

    }

    @Override
    public void addLikes() {
        post.addlike(0);
    }

    public Post createPost(){
        return post;

    }
}
