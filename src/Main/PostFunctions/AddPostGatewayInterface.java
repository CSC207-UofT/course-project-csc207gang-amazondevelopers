package PostFunctions;

import UserFunctions.User;

import java.io.IOException;

public interface AddPostGatewayInterface {
    public void addPost(Post post, User user) throws IOException, ClassNotFoundException;
    public void addFeed(Post post, User user) throws IOException, ClassNotFoundException;
}
