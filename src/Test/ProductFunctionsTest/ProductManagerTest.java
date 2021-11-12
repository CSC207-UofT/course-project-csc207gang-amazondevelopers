package ProductFunctionsTest;

import ProductFunctions.CreateProductController;
import ProductFunctions.CreateProductGateway;
import ProductFunctions.Product;
import ProductFunctions.ProductManager;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductManagerTest {

//     CreateProductGateway productGateway = new CreateProductGateway();
//     ProductManager productManager = new ProductManager(productGateway);

//     //TODO: need to delete each product from repo after creating them for each test

//     @Test
//     void createProductSizeBasicTest() throws IOException, ClassNotFoundException {
//         Product actualProduct = productManager.createProduct("shoe", "1", 5.0, "shoes", "2",1);
//         // move to the next set of inputs for next test
//         assertTrue(actualProduct.getName() == "shoe");
//         assertTrue(actualProduct.getId() == "1");
//         assertTrue(actualProduct.getPrice() == 5);
//         assertTrue(actualProduct.getCategory() == "shoes");
//         assertTrue(actualProduct.getQuantity() == 1);
//         assertTrue(actualProduct.getSizes() == "2");
//     }

//     @Test
//     void createProductNoSizeBasicTest() throws IOException, ClassNotFoundException {
//         Product actualProduct = productManager.createProduct("shoe", "1", 5.0, "shoes",1);

//         assertTrue(actualProduct.getName() == "shoe");
//         assertTrue(actualProduct.getId() == "1");
//         assertTrue(actualProduct.getPrice() == 5);
//         assertTrue(actualProduct.getCategory() == "shoes");
//         assertTrue(actualProduct.getQuantity() == 1);
//         assertTrue(actualProduct.getSizes() == null);
//     }

//     @Test
//     void createProductNegativePriceTest() throws Exception {
//         Product actualProduct = productManager.createProduct("shoe", "1", -5.0, "shoes",1);

//         assertTrue(actualProduct.getName() == "shoe");
//         assertTrue(actualProduct.getId() == "1");
//         assertTrue(actualProduct.getPrice() >= 0);
//         assertTrue(actualProduct.getCategory() == "shoes");
//         assertTrue(actualProduct.getQuantity() == 1);
//         assertTrue(actualProduct.getSizes() == null);
//     }

//     @Test
//     void createProductNegativeQuantityTest() throws Exception {
//         Product actualProduct = productManager.createProduct("shoe", "9999", -5.0, "shoes",-50);

//         assertTrue(actualProduct.getName() == "shoe");
//         assertTrue(actualProduct.getId() == "1");
//         assertTrue(actualProduct.getPrice() >= 0);
//         assertTrue(actualProduct.getCategory() == "shoes");
//         assertTrue(actualProduct.getQuantity() >= 0);
//         assertTrue(actualProduct.getSizes() == null);
//     }

//     @Test
//     void createProductZeroQuantityTest() throws Exception {
//        assertTrue(productManager.createProduct("shoe", "9999", -5.0, "shoes",0) == null);
//     }

//     @Test
//     void createProductSameProductsWithSizeTest() throws Exception {
//         Product actualProduct = productManager.createProduct("shoe", "1", 5.0, "shoes", "2",1);
//         assertTrue(actualProduct.getName() == "shoe");
//         assertTrue(actualProduct.getId() == "1");
//         assertTrue(actualProduct.getPrice() == 5);
//         assertTrue(actualProduct.getCategory() == "shoes");
//         assertTrue(actualProduct.getQuantity() == 1);
//         assertTrue(actualProduct.getSizes() == "2");

//         assertTrue(productManager.createProduct("shoe", "1", 5.0, "shoes", "2",1) == null);
//     }

//     @Test
//     void createProductSameProductsWithNoSizeTest() throws Exception {
//         Product actualProduct = productManager.createProduct("shoe", "9999", -5.0, "shoes",0);
//         assertTrue(actualProduct.getName() == "shoe");
//         assertTrue(actualProduct.getId() == "1");
//         assertTrue(actualProduct.getPrice() == 5);
//         assertTrue(actualProduct.getCategory() == "shoes");
//         assertTrue(actualProduct.getQuantity() == 1);
//         assertTrue(actualProduct.getSizes() == "2");

//         assertTrue(productManager.createProduct("shoe", "9999", -5.0, "shoes",0) == null);
//     }









//     @Test
//     void decreaseQuantityBasic() throws Exception {
//         Product product = productManager.createProduct("shoe", "9999", -5.0, "shoes",2);
//         assertTrue(productManager.decreaseQuantity("1", 1));
//         assertTrue(product.getQuantity() == 1);
//     }

//     @Test
//     void decreaseQuantityBasic2() throws Exception {
//         Product product = productManager.createProduct("shoe", "9999", -5.0, "shoes",50);
//         assertTrue(productManager.decreaseQuantity("1", 26));
//         assertTrue(product.getQuantity() == 24);
//     }

//     @Test
//     void decreaseQuantityNegative() throws Exception {
//         Product product = productManager.createProduct("shoe", "9999", -5.0, "shoes",2);
//         assertTrue(productManager.decreaseQuantity("1", -50));
//         assertTrue(product.getQuantity() == 0);
//     }

//     @Test
//     void decreaseQuantityZero() throws Exception {
//         Product product = productManager.createProduct("shoe", "9999", -5.0, "shoes",2);
//         assertTrue(productManager.decreaseQuantity("1", 0));
//         assertTrue(product.getQuantity() == 2);
//     }

//     @Test
//     void decreaseQuantityProductDoesNotExiist() throws Exception {
//         assertFalse(productManager.decreaseQuantity("72673638716888391876387", 1));
//     }








//     @Test
//     void increaseQuantityBasic() throws Exception {
//         Product product = productManager.createProduct("shoe", "9999", -5.0, "shoes",2);
//         assertTrue(productManager.decreaseQuantity("1", 1));
//         assertTrue(product.getQuantity() == 3);
//     }

//     @Test
//     void increaseQuantityBasic2() throws Exception {
//         Product product = productManager.createProduct("shoe", "9999", -5.0, "shoes",2);
//         assertTrue(productManager.decreaseQuantity("1", 51));
//         assertTrue(product.getQuantity() == 53);
//     }

//     @Test
//     void increaseQuantityNegative() throws Exception {
//         Product product = productManager.createProduct("shoe", "9999", -5.0, "shoes",2);
//         assertFalse(productManager.decreaseQuantity("1", -50));
//         assertTrue(product.getQuantity() == 2);
//     }

//     @Test
//     void increaseQuantityZero() throws Exception {
//         Product product = productManager.createProduct("shoe", "9999", -5.0, "shoes",2);
//         assertTrue(productManager.decreaseQuantity("1", 0));
//         assertTrue(product.getQuantity() == 2);
//     }

//     @Test
//     void increaseQuantityProductDoesNotExiist() throws Exception {
//         assertFalse(productManager.decreaseQuantity("92837178937816786472", 5));
//     }



}
