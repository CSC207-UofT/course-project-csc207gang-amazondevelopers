package browseFunctionsTest;

import login.SaveUserGateway;
import login.SignInController;
import login.SignUpController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import options.post.Post;
import product.Product;
import user.User;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BrowseControllerTest {
    SignInController signin = new SignInController();
    SignUpController signup = new SignUpController();
    SignUpGateway signUpGateway = new SignUpGateway();

    User testUser1 = new User("followed");
    User testUser2 = new User("follower");
    Product testProduct = new Product("shoes", "TEST", 5.0, "shoes", "2",1);
    Post post = new Post(testProduct, testUser2);

    CreateProductGateway createProductGateway = new CreateProductGateway();
    productFunctions.GetProductGateway getProductGateway = new productFunctions.GetProductGateway();
    productFunctions.ProductUseCase productUseCaseCreate = new productFunctions.ProductUseCase(createProductGateway);
    GetUserGateway getUserGateway = new GetUserGateway();
    AddPostGateway addPostGateway = new AddPostGateway();

    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();

    BrowseController browseController = new BrowseController(testUser1);


    SaveUserGateway saveUserGateway = new SaveUserGateway();


    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        // create two users, and a options.post
        // if there is a preexisting user TestCreateProductUser, delete it
        deleteUserGateway.deleteUser("follower");
        deleteUserGateway.deleteUser("followed");
        // create the new user profile before each test
        saveUserGateway.saveUser("followed", testUser1);
        saveUserGateway.saveUser("following", testUser2);

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
    public void presentFeedBasicTest() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/optionsPackageTest/optionsTestInputs/SearchControllerBasicTestInputs");
        //skip the header of the file
        testInOut.getInput();

        //search for the product, then buy it
        browseController.presentFeed(testInOut);

        productFunctions.Product bought = getProductGateway.getProduct("TEST");
        User user = getUserGateway.getUser("TestBrowse");
        assertEquals(0, bought.getQuantity());
        assertEquals(0, user.getShoppingCart().size());
    }

    @Test
    public void presentFeedEmptyTest() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/optionsPackageTest/optionsTestInputs/SearchControllerBasicTestInputs");
        //skip the header of the file
        testInOut.getInput();

        //search for the product, then buy it
        browseController.presentFeed(testInOut);

        Product bought = getProductGateway.getProduct("TEST");
        User user = getUserGateway.getUser("TestBrowse");
        assertEquals(0, bought.getQuantity());
        assertEquals(0, user.getShoppingCart().size());
    }


}
