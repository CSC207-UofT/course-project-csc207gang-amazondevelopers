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
import org.junit.jupiter.api.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



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
    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway()
    ProductDeletionUseCase deleteProducts = new ProductDeletionUseCase(testUser, deleteProductsGateway);
    CreateProductController createProduct = new CreateProductController();


    @Test
    void createProductSizeTest() throws Exception {
        // read the header
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);

        // move to the next set of inputs for next test
        testInOut.getInput();

        Assertions.assertEquals("shoe", actualProduct.getName());
        Assertions.assertEquals("7235617782136781667163817", actualProduct.getId());
        Assertions.assertEquals(5, actualProduct.getPrice());
        Assertions.assertEquals("shoes", actualProduct.getCategory());
        Assertions.assertEquals(2, actualProduct.getQuantity());
        Assertions.assertEquals("1", actualProduct.getSizes());

        ArrayList<String> products = new ArrayList<>();
        products.add("1");

        deleteProducts.deleteProducts();

    }

    @Test
    void createProductNoSizeTest() throws Exception {
        testInOut.getInput();
        Product actualProduct = createProduct.createNewProductFromInput(testInOut, testUser);
        testInOut.getInput();

        Assertions.assertEquals("shoe", actualProduct.getName());
        Assertions.assertEquals("7235617782136781667163817", actualProduct.getId());
        Assertions.assertEquals(5, actualProduct.getPrice());
        Assertions.assertEquals("shoes", actualProduct.getCategory());
        Assertions.assertEquals(2, actualProduct.getQuantity());
        Assertions.assertNull(actualProduct.getSizes());

        deleteProducts.deleteProducts();
    }

    @Test
    void createProductUndoNameTest() throws Exception {
        testInOut.getInput();
        Product actualProduct =  createProduct.createNewProductFromInput(testInOut, testUser);
        testInOut.getInput();


        Assertions.assertEquals("dress", actualProduct.getName());
        Assertions.assertEquals("7235617782136781667163817", actualProduct.getId());
        Assertions.assertEquals(5, actualProduct.getPrice());
        Assertions.assertEquals("shoes", actualProduct.getCategory());
        Assertions.assertEquals(2, actualProduct.getQuantity());
        Assertions.assertNull(actualProduct.getSizes());

        deleteProducts.deleteProducts();
    }

    @Test
    void createProductMultipleUndoTest() throws Exception {
        testInOut.getInput();
        Product actualProduct =  createProduct.createNewProductFromInput(testInOut, testUser);
        testInOut.getInput();


        Assertions.assertEquals("dress", actualProduct.getName());
        Assertions.assertEquals("7235617782136781667163817", actualProduct.getId());
        Assertions.assertEquals(400, actualProduct.getPrice());
        Assertions.assertEquals("pants", actualProduct.getCategory());
        Assertions.assertEquals(2, actualProduct.getQuantity());
        Assertions.assertEquals("3", actualProduct.getSizes());

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
