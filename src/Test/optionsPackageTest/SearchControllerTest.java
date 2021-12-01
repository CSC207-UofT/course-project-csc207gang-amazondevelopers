package optionsPackageTest;
//
import inputOutputFunctions.SystemInOut;
import inputOutputFunctions.SystemInOutTest;
import productFunctions.*;
import settingsFunctions.DeleteProductsGateway;
import settingsFunctions.DeleteUserGateway;
import loginFunctions.GetUserGateway;
import loginFunctions.SignUpGateway;
import userFunctions.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import optionsPackage.SearchController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
// TODO: Search controller currently is untestable, need to fix
public class SearchControllerTest{
    SignUpGateway signUpGateway = new SignUpGateway();

    User testUser = new User("TestSearchControllerUser");
    SearchController searchController = new SearchController(testUser);
    Product testProduct = new Product("shoes", "TEST", 5.0, "shoes", "2",1);;

    CreateProductGateway createProductGateway = new CreateProductGateway();
    GetProductGateway getProductGateway = new GetProductGateway();
    ProductUseCase productUseCaseCreate = new ProductUseCase(createProductGateway);
    GetUserGateway getUserGateway = new GetUserGateway();

    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        // TODO: fix the comments in each test so that they make sense for the class that they are in
        // if there is a preexisting user TestSearchControllerUser, delete it
        deleteUserGateway.deleteUser("TestSearchControllerUser");
        // create the new user profile before each test
        signUpGateway.allowSignUp("TestSearchControllerUser", testUser);

        // save a product to the repo to test with
        productUseCaseCreate.saveNewProductToSer(testProduct);
    }

    @After
    public void takeDown() throws IOException, ClassNotFoundException {
        // delete the test user profile before each test, to delete all the products that were created during the test
        deleteUserGateway.deleteUser("TestSearchControllerUser");
        ArrayList<String> ids = new ArrayList<>();
        ids.add("TEST");
        deleteProductsGateway.deleteProducts(ids);
    }

    @Test
    public void allowSearchBasicTest() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/OptionsPackageTest/SearchControllerBasicTestInputs");
        //skip the header of the file
        testInOut.getInput();

        //search for the product, then buy it
        searchController.allowSearch(testInOut);

        Product bought = getProductGateway.getProduct("TEST");
        User user = getUserGateway.getUser("TestSearchControllerUser");
        assertEquals(0, bought.getQuantity());
        assertEquals(0, user.getShoppingCart().size());
    }

    @Test
    public void allowSearchNoProductsTest() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/OptionsPackageTest/SearchControllerNoProductsTestInputs");
        //skip the header of the file
        testInOut.getInput();

        // try searching for the product
        searchController.allowSearch(testInOut);
        // if the next line in the file is the empty string, then we can finish the test
        assertEquals("", testInOut.getInput());
    }

    @Test
    public void allowSearchSoldOutTest() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/OptionsPackageTest/SearchControllerBasicTestInputs");
        //skip the header of the file
        testInOut.getInput();

        //search for the product, then buy it
        searchController.allowSearch(testInOut);

        Product bought = getProductGateway.getProduct("TEST");
        User user = getUserGateway.getUser("TestSearchControllerUser");
        assertEquals(0, bought.getQuantity());
        assertEquals(0, user.getShoppingCart().size());


        testInOut = new SystemInOutTest("src/Test/OptionsPackageTest/SearchControllerSoldOutTestInputs");
        //skip the header of the file
        testInOut.getInput();
        //search for the product again to see if the product information has been updated
        searchController.allowSearch(testInOut);

        bought = getProductGateway.getProduct("TEST");
        user = getUserGateway.getUser("TestSearchControllerUser");
        assertEquals(0, bought.getQuantity());
        assertEquals(0, user.getShoppingCart().size());
    }
}