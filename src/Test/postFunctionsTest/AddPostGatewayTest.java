package postFunctionsTest;
import productFunctions.Product;
import settingsFunctions.DeleteUserGateway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import postFunctions.Post;
import postFunctions.AddPostGateway;
import java.io.IOException;
import userFunctions.User;
import loginFunctions.GetUserGateway;
import loginFunctions.SignUpGateway;
import inputOutputFunctions.SystemInOut;

import static org.junit.Assert.*;
public class AddPostGatewayTest {
    private User newUser;
    private SystemInOut inOut = new SystemInOut();
    @Before
    public void setup() throws IOException, ClassNotFoundException {
        newUser = new User("TestPost");
        SignUpGateway signUp = new SignUpGateway();
        signUp.allowSignUp(newUser.getUsername(), newUser);

    }
    @Test
    public void testAddPost() throws IOException, ClassNotFoundException {
        Product product = new Product("shoe", "1", 5.0, "shoes", "2",1);
        Post expectedPost = new Post(product, "Shoe post", true, true,newUser);
        AddPostGateway apg = new AddPostGateway();
        apg.addPost(expectedPost,newUser);
        GetUserGateway getUser = new GetUserGateway();
        newUser = getUser.getUser("TestPost");
        Post newpost = newUser.getListPosts().get(0);
        assertEquals(newpost.getCaption() , expectedPost.getCaption());
        assertEquals(newpost.getCanComment() , expectedPost.getCanComment());

    }
    @Test
    public void testAddFeed() throws IOException, ClassNotFoundException {
        Product product = new Product("shoe", "1", 5.0, "shoes", "2",1);
        Post expectedPost = new Post(product, "Shoe post", true, true,newUser);
        AddPostGateway apg = new AddPostGateway();
        apg.addFeed(expectedPost,newUser);
        GetUserGateway getUser = new GetUserGateway();
        newUser = getUser.getUser("TestPost");
        Post newpost = newUser.getFeed().get(0);
        assertEquals(newpost.getCaption() , expectedPost.getCaption());
        assertEquals(newpost.getCanComment() , expectedPost.getCanComment());

    }
    @After
    public void teardown() throws IOException, ClassNotFoundException {
        DeleteUserGateway deleteUserGateway = new DeleteUserGateway();
        deleteUserGateway.deleteUser("TestPost");
    }
}
