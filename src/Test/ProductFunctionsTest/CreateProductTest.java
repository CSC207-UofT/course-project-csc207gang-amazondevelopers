package ProductFunctionsTest;

import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;
import ProductFunctions.CreateProductController;
import ProductFunctions.CreateProductGateway;
import ProductFunctions.Product;
import ProductFunctions.ProductManager;
import Settings.DeleteProductsGateway;
import Settings.ProductDeletionUseCase;
import UserFunctions.User;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
    User testUser = new User("TestCreateProductUser");
    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
    ProductDeletionUseCase deleteProducts = new ProductDeletionUseCase(testUser, deleteProductsGateway);
    CreateProductController createProduct = new CreateProductController();


    @Test
    void createProductSizeTest() throws Exception {
        // read the header
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);

        // move to the next set of inputs for next test
        testInOut.getInput();

        assertEquals("shoe", actualProduct.getName());
        assertEquals("7235617782136781667163817", actualProduct.getId());
        assertEquals(5, (double) actualProduct.getPrice());
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertEquals("1", actualProduct.getSizes());

        ArrayList<String> products = new ArrayList<>();
        products.add("1");

        deleteProducts.deleteProducts();

    }

    @Test
    void createProductNoSizeTest() throws Exception {
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
        testInOut.getInput();

        assertEquals("shoe", actualProduct.getName());
        assertEquals("7235617782136781667163817", actualProduct.getId());
        assertEquals(5, (double)actualProduct.getPrice());
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertNull(actualProduct.getSizes());

        deleteProducts.deleteProducts();
    }

    @Test
    void createProductUndoNameTest() throws Exception {
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
        testInOut.getInput();


        assertEquals("dress", actualProduct.getName());
        assertEquals("7235617782136781667163817", actualProduct.getId());
        assertEquals(5, (double) actualProduct.getPrice());
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertNull(actualProduct.getSizes());

        deleteProducts.deleteProducts();
    }

    @Test
    void createProductMultipleUndoTest() throws Exception {
        testInOut.getInput();
        Product actualProduct =  createProduct.createNewProductFromInput(testInOut, testUser);
        testInOut.getInput();


        assertEquals("dress", actualProduct.getName());
        assertEquals("7235617782136781667163817", actualProduct.getId());
        assertEquals(400, (double)actualProduct.getPrice());
        assertEquals("pants", actualProduct.getCategory());
        assertEquals(2, actualProduct.getQuantity());
        assertEquals("3", actualProduct.getSizes());

        deleteProducts.deleteProducts();
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
