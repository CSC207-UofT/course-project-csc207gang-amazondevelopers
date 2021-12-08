package options.post;

import user.User;

public class PostBuilderWithComments implements PostBuilderInterface{
    Post post = new Post();


    @Override
    public void addComment() { this.post.addComment("");

    }

    @Override
    public void addCaption(String caption) { this.post.setCaption(caption);

    }

    @Override
    public void addProduct(String productID) { this.post.setProduct(productID);

    }

    @Override
    public void addUser(User user) { this.post.setUser(user);

    }

    @Override
    public void addLikes() {
        this.post.addlike(0);
    }

    public Post createPost(){
        return this.post;

    }
}
//