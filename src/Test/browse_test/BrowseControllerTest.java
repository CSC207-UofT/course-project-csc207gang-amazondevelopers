package browse_test;

import delete_gateways.DeleteProductsGateway;
import delete_gateways.DeleteUserGateway;
import login.SaveUserGateway;
import options.browse.BrowseController;
import options.post.Post;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import product.Product;
import product.SaveProductGateway;
import user.User;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BrowseControllerTest {

    User testUser1 = new User("followed");
    User testUser2 = new User("follower");
    User testUser3 = new User("NoFollowing");
    Product testProduct = new Product("shoes", "TEST", 5.0, "shoes", "2",1);
    Post post = new Post(testProduct.getId(), "test", true, true, testUser2);

    SaveProductGateway saveProductGateway = new SaveProductGateway();
    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();

    BrowseController browseController = new BrowseController(testUser1);


    SaveUserGateway saveUserGateway = new SaveUserGateway();


    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        // create two users, and a post
        // if there is a preexisting user TestCreateProductUser, delete it
        deleteUserGateway.deleteUser("followed");
        deleteUserGateway.deleteUser("follower");
        deleteUserGateway.deleteUser("NoFollowing");

        // create the new user profile before each test
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post);
        testUser2.setListPosts(posts);

        ArrayList<String> followers = new ArrayList<>();
        followers.add(testUser2.getUsername());
        testUser1.setListFollowing(followers);

        saveUserGateway.saveUser("followed", testUser1);
        saveUserGateway.saveUser("follower", testUser2);
        saveUserGateway.saveUser("NoFollowing", testUser3);

        saveProductGateway.addProductToRepo(testProduct, "TEST", "shoes");

    }

    @After
    public void takeDown() {
        // delete the test user profile before each test, to delete all the products that were created during the test
        deleteUserGateway.deleteUser("TestSignUpControllerUser");
        deleteUserGateway.deleteUser("follower");
        deleteUserGateway.deleteUser("TestBrowse");
        ArrayList<String> ids = new ArrayList<>();
        ids.add("TEST");
        deleteProductsGateway.deleteProducts(ids);
    }

    @Test
    public void presentFeedBasicTest() {
        ArrayList<Post> feed = browseController.getFeed();
        assertEquals(1, feed.size());
        assertEquals(feed.get(0).getUser().getUsername(), "follower");
    }

    @Test
    public void presentFeedEmptyTest() {
        BrowseController browseController2 = new BrowseController(testUser3);
        ArrayList<Post> feed = browseController2.getFeed();
        assertEquals(0, feed.size());
    }




}
