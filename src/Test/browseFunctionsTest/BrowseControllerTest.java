package browseFunctionsTest;

import browse.BrowseController;
import login_functions.SaveUserGateway;
import login_functions.SignInController;
import login_functions.SignUpController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import post.Post;
import product.Product;
import user.User;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BrowseControllerTest {
    SignInController signin = new SignInController();
    SignUpController signup = new SignUpController();

    User testUser1 = new User("followed");
    User testUser2 = new User("follower");
    User testUser3 = new User("NoFollowing");
    Product testProduct = new Product("shoes", "TEST", 5.0, "shoes", "2",1);
    Post post = new Post(testProduct, testUser2);

    CreateProductGateway createProductGateway = new CreateProductGateway();
    productFunctions.GetProductGateway getProductGateway = new productFunctions.GetProductGateway();
    productFunctions.ProductUseCase productUseCaseCreate = new productFunctions.ProductUseCase(createProductGateway);

    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();

    BrowseController browseController = new BrowseController(testUser1);


    SaveUserGateway saveUserGateway = new SaveUserGateway();


    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        // create two users, and a post
        // if there is a preexisting user TestCreateProductUser, delete it
        deleteUserGateway.deleteUser("follower");
        deleteUserGateway.deleteUser("followed");
        deleteUserGateway.deleteUser("NoFollowing");
        // create the new user profile before each test
        saveUserGateway.saveUser("followed", testUser1);
        saveUserGateway.saveUser("following", testUser2);
        saveUserGateway.saveUser("NoFollowing", testUser3);

        createProductGateway.addProductToRepo(testProduct, "TEST", "shoes");
        addPostGateway.addPost(post, testUser2);

    }

    @After
    public void takeDown() throws IOException, ClassNotFoundException {
        // delete the test user profile before each test, to delete all the products that were created during the test
        deleteUserGateway.deleteUser("TestSignUpControllerUser");
        deleteUserGateway.deleteUser("follower");
        deleteUserGateway.deleteUser("TestBrowse");
        ArrayList<String> ids = new ArrayList<>();
        ids.add("TEST");
        deleteProductsGateway.deleteProducts(ids);
    }

    @Test
    public void presentFeedBasicTest() throws IOException, ClassNotFoundException {
        ArrayList<Post> feed = browseController.getFeed();
        assertEquals(1, feed.size());
        assertEquals(feed.get(0).getUser().getUsername(), "followed");
    }

    @Test
    public void presentFeedEmptyTest() throws IOException, ClassNotFoundException {
        BrowseController browseController2 = new BrowseController(testUser3);
        ArrayList<Post> feed = browseController2.getFeed();
        assertEquals(0, feed.size());
    }



}
