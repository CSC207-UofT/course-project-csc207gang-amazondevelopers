package PostFunctions;
import UserFunctions.User;
import java.io.IOException;

public interface AddPostGatewayInterface {
    void addPost(Post post, User user) throws IOException, ClassNotFoundException;
    void addFeed(Post post, User user) throws IOException, ClassNotFoundException;
}
