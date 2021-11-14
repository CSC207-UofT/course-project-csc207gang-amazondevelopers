package ProductFunctionsTest;

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


public class CreateProductTest {

    SystemInOutTest testInOut;

    {
        try {
            testInOut = new SystemInOutTest("src/Test/ProductFunctionsTest/CreateProductTestInputs");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    SignUpGateway signUpGateway = new SignUpGateway();
    User testUser = new User("TestCreateProductUser");

    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();
    ProductDeletionUseCase deleteProducts = new ProductDeletionUseCase(testUser, deleteProductsGateway);
    CreateProductController createProduct = new CreateProductController();

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        deleteUserGateway.deleteUser("CreateProductTestUser");
        signUpGateway.allowSignUp("CreateProductTestUser", testUser);
    }

    @After
    public void takeDown() throws IOException, ClassNotFoundException {
        deleteUserGateway.deleteUser("CreateProductTestUser");
    }

    @Test
    public void createProductSizeTest() throws Exception {
        // read the header
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);

        // move to the next set of inputs for next test
        String line = testInOut.getInput();

        assertEquals("shoe", actualProduct.getName());
        assertEquals(5, actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertEquals("1", actualProduct.getSizes());

        Post newPost = testUser.getListPosts().get(0);
        assertEquals("these are shoes", newPost.getCaption());
        assertTrue(newPost.getCanComment());
        assertTrue(newPost.getCanRate());

        // ArrayList<String> products = new ArrayList<>();
        // products.add("1");

        // deleteProducts.deleteProducts();

    }

    @Test
    public void createProductNoSizeTest() throws Exception {
        try {
            testInOut = new SystemInOutTest("src/Test/ProductFunctionsTest/CreateProductTestNoSizeInputs");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String header = testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
        testInOut.getInput();

        assertEquals("shoe", actualProduct.getName());
        // assertEquals("7235617782136781667163817", actualProduct.getId());
        assertEquals(5, actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertNull(actualProduct.getSizes());

        Post newPost = testUser.getListPosts().get(0);
        assertEquals("these are shoes", newPost.getCaption());
        assertTrue(newPost.getCanComment());
        assertFalse(newPost.getCanRate());

        // deleteProducts.deleteProducts();
    }

    @Test
    public void createProductCantCommentTest() throws Exception {
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
        testInOut.getInput();

        assertEquals("shoe", actualProduct.getName());
        assertEquals(5, actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
       // System.out.println(actualProduct.getSizes());
        assertNull(actualProduct.getSizes());

        Post newPost = testUser.getListPosts().get(0);
        assertEquals("these are shoes", newPost.getCaption());
        assertFalse(newPost.getCanComment());
        assertTrue(newPost.getCanRate());

       //  deleteProducts.deleteProducts();
       // assertTrue(testUser.getProductsPosted().isEmpty());
    }

    @Test
    public void createProductCantRateTest() throws Exception {
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
        testInOut.getInput();

        assertEquals("shoe", actualProduct.getName());
        assertEquals(5, actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());

        assertEquals("jsdhkjh", actualProduct.getSizes());
        // assertNull(actualProduct.getSizes());

        Post newPost = testUser.getListPosts().get(0);
        assertEquals("these are shoes", newPost.getCaption());
        assertTrue(newPost.getCanComment());
        assertFalse(newPost.getCanRate());

        // deleteProducts.deleteProducts();
    }

    @Test
    public void createProductUndoNameTest() throws Exception {
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
        testInOut.getInput();


        assertEquals("dress", actualProduct.getName());
        assertEquals(5, actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertNull(actualProduct.getSizes());

        // deleteProducts.deleteProducts();
    }

    @Test
    public void createProductMultipleUndoTest() throws Exception {
        testInOut.getInput();
        Product actualProduct =  createProduct.createNewProductFromInput(testInOut, testUser);
        testInOut.getInput();

        assertEquals("dress", actualProduct.getName());
        assertEquals(400, actualProduct.getPrice(), 0.0);
        assertEquals("pants", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertEquals("3", actualProduct.getSizes());

        Post newPost = testUser.getListPosts().get(0);
        assertEquals("these are shoes", newPost.getCaption());
        assertFalse(newPost.getCanComment());
        assertTrue(newPost.getCanRate());

        // deleteProducts.deleteProducts();
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







    private class SystemInOutTest extends SystemInOut {

        private final Scanner reader;

        /**
         *
         * @param fileName
         * @throws FileNotFoundException
         */
        public SystemInOutTest(String fileName) throws FileNotFoundException {
            File fileToRead = new File(fileName);
            this.reader = new Scanner(fileToRead);
        }

        @Override
        public String getInput() throws IOException {
            if (reader.hasNextLine()) {
                return this.reader.nextLine();
            }
            else{
                return "";
            }
        }
    }

}
