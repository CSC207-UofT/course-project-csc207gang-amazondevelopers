package ProductFunctionsTest;

import InputAndOutput.SystemInOutTest;
import Settings.DeleteUserGateway;
import login.SignUpGateway;
import InputAndOutput.SystemInOut;
import PostFunctions.Post;
import ProductFunctions.CreateProductController;
import ProductFunctions.Product;
import Settings.DeleteProductsGateway;
import Settings.ProductDeletionUseCase;
import UserFunctions.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;


public class CreateProductControllerTest {

    SignUpGateway signUpGateway = new SignUpGateway();
    // create a new user profile to make products for
    User testUser = new User("TestCreateProductUser");

    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();
    CreateProductController createProduct = new CreateProductController();

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        // if there is a preexisting user TestCreateProductUser, delete it
        deleteUserGateway.deleteUser("TestCreateProductUser");
        // create the new user profile before each test
        signUpGateway.allowSignUp("TestCreateProductUser", testUser);
    }

    @After
    public void takeDown() throws IOException, ClassNotFoundException {
        // delete the test user profile before each test, to delete all the products that were created during the test
        deleteUserGateway.deleteUser("TestCreateProductUser");
    }

    @Test
    public void createProductSizeTest() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/ProductFunctionsTest/CreateProductTestInputs");

        // skip the header of the file
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);


        assertEquals("shoe", actualProduct.getName());
        assertEquals(5, actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertEquals("1", actualProduct.getSizes());

        Post newPost = testUser.getListPosts().get(0);
        assertEquals("these are shoes", newPost.getCaption());
        assertTrue(newPost.getCanComment());
        assertTrue(newPost.getCanRate());
    }

    @Test
    public void createProductNoSizeTest() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/ProductFunctionsTest/CreateProductTestNoSizeInputs");

        // skip the header of the file
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);

        assertEquals("shoe", actualProduct.getName());
        assertEquals(5, actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertNull(actualProduct.getSizes());

        Post newPost = testUser.getListPosts().get(0);
        assertEquals("these are shoes", newPost.getCaption());
        assertTrue(newPost.getCanComment());
        assertTrue(newPost.getCanRate());
    }

    @Test
    public void createProductCantCommentTest() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/ProductFunctionsTest/CreateProductCantCommentTestInputs");

        // skip the header of the file
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);

        assertEquals("shoe", actualProduct.getName());
        assertEquals(5, actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertNull(actualProduct.getSizes());

        Post newPost = testUser.getListPosts().get(0);
        assertEquals("these are shoes", newPost.getCaption());
        assertFalse(newPost.getCanComment());
        assertTrue(newPost.getCanRate());
    }

    @Test
    public void createProductCantRateTest() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/ProductFunctionsTest/CreateProductCantRateTestInputs");

        // skip the header of the file
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);

        assertEquals("shoe", actualProduct.getName());
        assertEquals(5, actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertNull(actualProduct.getSizes());

        Post newPost = testUser.getListPosts().get(0);
        assertEquals("these are shoes", newPost.getCaption());
        assertTrue(newPost.getCanComment());
        assertFalse(newPost.getCanRate());
    }

    @Test
    public void createProductUndoNameTest() throws Exception {
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/ProductFunctionsTest/CreateProductUndoNameTestInputs");

        // skip the header of the file
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);

        assertEquals("dress", actualProduct.getName());
        assertEquals(5, actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertNull(actualProduct.getSizes());
    }

    @Test
    public void createProductMultipleUndoTest() throws Exception {
        // TODO: currently user cannot undo what they input for CanRate as the product is created immediatly after
        SystemInOutTest testInOut = new SystemInOutTest("src/Test/ProductFunctionsTest/CreateProductMultipleUndoTestInputs");

        // skip the header of the file
        testInOut.getInput();
        Product actualProduct =  createProduct.createNewProductFromInput(testInOut, testUser);

        assertEquals("dress", actualProduct.getName());
        assertEquals(400, actualProduct.getPrice(), 0.0);
        assertEquals("pants", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertEquals("3", actualProduct.getSizes());

        Post newPost = testUser.getListPosts().get(0);
        assertEquals("these are shoes", newPost.getCaption());
        assertTrue(newPost.getCanComment());
        assertFalse(newPost.getCanRate());
    }

//
//    @Test
//    void createProductBadInputsAllStringsTest() throws Exception {
//        testInOut.getInput();
//        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
//        testInOut.getInput();
//
//        deleteProducts.deleteProducts();
//    }
//
//    @Test
//    void createProductDuplicateProductsTest() throws Exception {
//        testInOut.getInput();
//        Product product1 = createProduct.createNewProductFromInput(testInOut, testUser);
//        testInOut.getInput();
//
//        Product product2 = createProduct.createNewProductFromInput(testInOut, testUser);
//        testInOut.getInput();
//
//        List<String> userProducts = testUser.getProductsPosted();
//        Assertions.assertEquals(1, userProducts.size());
//
//        deleteProducts.deleteProducts();
//    }
//
//    @Test
//    void createProductBadInputsNegativePriceTest() throws Exception {
//        testInOut.getInput();
//        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
//        testInOut.getInput();
//
//        deleteProducts.deleteProducts();
//    }
//
//    @Test
//    void createProductZeroPriceTest() throws Exception {
//        testInOut.getInput();
//        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
//        testInOut.getInput();
//
//        deleteProducts.deleteProducts();
//    }
//
//    @Test
//    void createProductBadInputsNegativeQuantityTest() throws Exception {
//        testInOut.getInput();
//        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
//        testInOut.getInput();
//
//        deleteProducts.deleteProducts();
//    }
//
//    @Test
//    void createProductBadInputsZeroQuantityTest() throws Exception {
//        testInOut.getInput();
//        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
//        testInOut.getInput();
//
//        deleteProducts.deleteProducts();
//    }

    //    @Test
//    void createProductUndoStartTest() throws Exception {
//        testInOut.getInput();
//        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
//        testInOut.getInput();
//
//        deleteProducts.deleteProducts();
//    }

    //    @Test
//    void createProductUndoEndTest() throws Exception {
//        testInOut.getInput();
//        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
//        testInOut.getInput();
//
//        deleteProducts.deleteProducts();
//    }



//
//    private class SystemInOutTest extends SystemInOut {
//
//        private final Scanner reader;
//
//        /**
//         *
//         * @param fileName
//         * @throws FileNotFoundException
//         */
//        public SystemInOutTest(String fileName) throws FileNotFoundException {
//            File fileToRead = new File(fileName);
//            this.reader = new Scanner(fileToRead);
//        }
//
//        @Override
//        public String getInput() throws IOException {
//            if (reader.hasNextLine()) {
//                return this.reader.nextLine();
//            }
//            else{
//                return "";
//            }
//        }
//    }

}
