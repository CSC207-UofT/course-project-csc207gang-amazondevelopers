package browseFunctionsTest;

import browseFunctions.BrowseController;
import inputOutputFunctions.SystemInOutTest;
import loginFunctions.GetUserGateway;
import loginFunctions.SignInController;
import loginFunctions.SignUpController;
import loginFunctions.SignUpGateway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import postFunctions.AddPostGateway;
import postFunctions.Post;
import product.CreateProductGateway;
import settingsFunctions.DeleteProductsGateway;
import settingsFunctions.DeleteUserGateway;
import userFunctions.User;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BrowseControllerTest {
    SignInController signin = new SignInController();
    SignUpController signup = new SignUpController();
    SignUpGateway signUpGateway = new SignUpGateway();

    User testUser1 = new User("TestSignUpControllerUser");
    User testUser2 = new User("follower");
    product.Product testProduct = new product.Product("shoes", "TEST", 5.0, "shoes", "2",1);
    Post post = new Post(testProduct, testUser2);

    product.CreateProductGateway createProductGateway = new CreateProductGateway();
    product.GetProductGateway getProductGateway = new product.GetProductGateway();
    product.ProductUseCase productUseCaseCreate = new product.ProductUseCase(createProductGateway);
    GetUserGateway getUserGateway = new GetUserGateway();
    AddPostGateway addPostGateway = new AddPostGateway();

    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();

    BrowseController browseController = new BrowseController(testUser1);


    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        // create two users, and a post
        // if there is a preexisting user TestCreateProductUser, delete it
        deleteUserGateway.deleteUser("follower");
        deleteUserGateway.deleteUser("TestBrowse");
        // create the new user profile before each test
        signUpGateway.allowSignUp("TestSignUpControllerUser", testUser1);
        signUpGateway.allowSignUp("follower", testUser2);
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

        product.Product bought = getProductGateway.getProduct("TEST");
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

        product.Product bought = getProductGateway.getProduct("TEST");
        User user = getUserGateway.getUser("TestBrowse");
        assertEquals(0, bought.getQuantity());
        assertEquals(0, user.getShoppingCart().size());
    }


}
