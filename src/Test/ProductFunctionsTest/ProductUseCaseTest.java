package ProductFunctionsTest;

import ProductFunctions.CreateProductGateway;
import ProductFunctions.GetProductGateway;
import ProductFunctions.Product;
import ProductFunctions.ProductUseCase;
import Settings.DeleteProductsGateway;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProductUseCaseTest {

    CreateProductGateway createProductGateway = new CreateProductGateway();
    GetProductGateway getProductGateway = new GetProductGateway();
    ProductUseCase productUseCaseCreate = new ProductUseCase(createProductGateway);
    ProductUseCase productUseCaseGet = new ProductUseCase(getProductGateway);
    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();

    //TODO: need to delete each product from repo after creating them for each test

    @After
    public void delete() throws IOException, ClassNotFoundException {
       ArrayList<String> testIds = new ArrayList<>();
       testIds.add("1");
       deleteProductsGateway.deleteProducts(testIds);
    }

    @Test
    public void createProductSizeBasicTest() throws IOException, ClassNotFoundException {
        Product actualProduct = productUseCaseCreate.saveNewProduct("shoe", "1", 5.0, "shoes", "2",1);

        assertEquals("shoe", actualProduct.getName());
        assertEquals("1", actualProduct.getId());
        assertEquals(5, (double) actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(1, actualProduct.getQuantity());
        assertEquals("2", actualProduct.getSizes());
    }

    @Test
    public void createProductNoSizeBasicTest() throws IOException, ClassNotFoundException {
        Product actualProduct = productUseCaseCreate.saveNewProduct("shoe", "1", 5.0, "shoes",1);

        assertEquals("shoe", actualProduct.getName());
        assertEquals("1", actualProduct.getId());
        assertEquals(5, (double) actualProduct.getPrice(), 0.0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(1, actualProduct.getQuantity());
        assertNull(actualProduct.getSizes());
    }

//    @Test
//    public void createProductNegativePriceTest() throws Exception {
//        Product actualProduct = productManager.createProduct("shoe", "1", -5.0, "shoes",1);
//
//        assertEquals("shoe", actualProduct.getName());
//        assertEquals("1", actualProduct.getId());
//        assertTrue(actualProduct.getPrice() >= 0);
//        assertEquals("shoes", actualProduct.getCategory());
//        assertEquals(1, actualProduct.getQuantity());
//        assertNull(actualProduct.getSizes());
//    }
//
//    @Test
//    public void createProductNegativeQuantityTest() throws Exception {
//        Product actualProduct = productManager.createProduct("shoe", "1", 5.0, "shoes",-50);
//
//        assertEquals("shoe", actualProduct.getName());
//        assertEquals("1", actualProduct.getId());
//        assertTrue(actualProduct.getPrice() >= 0);
//        assertEquals("shoes", actualProduct.getCategory());
//        assertTrue(actualProduct.getQuantity() >= 0);
//        assertNull(actualProduct.getSizes());
//    }

    @Test
    public void createProductZeroQuantityTest() throws Exception {
        Product actualProduct = productUseCaseCreate.saveNewProduct("shoe", "1", 5.0, "shoes", 0);
        assertEquals("shoe", actualProduct.getName());
        assertEquals("1", actualProduct.getId());
        assertTrue(actualProduct.getPrice() >= 0);
        assertEquals("shoes", actualProduct.getCategory());
        assertEquals(0, actualProduct.getQuantity());
        assertNull(actualProduct.getSizes());
    }

//    @Test
//    public void createProductSameProductsWithSizeTest() throws Exception {
//        Product actualProduct = productManager.createProduct("shoe", "1", 5.0, "shoes", "2",1);
//        assertEquals("shoe", actualProduct.getName());
//        assertEquals("1", actualProduct.getId());
//        assertEquals(5, (double) actualProduct.getPrice(), 0.0);
//        assertEquals("shoes", actualProduct.getCategory());
//        assertEquals(1, actualProduct.getQuantity());
//        assertEquals("2", actualProduct.getSizes());
//
//        assertNull(productManager.createProduct("shoe", "1", 5.0, "shoes", "2", 1));
//    }
//
//    @Test
//    public void createProductSameProductsWithNoSizeTest() throws Exception {
//        Product actualProduct = productManager.createProduct("shoe", "9999", -5.0, "shoes",0);
//        assertTrue(actualProduct.getName() == "shoe");
//        assertTrue(actualProduct.getId() == "1");
//        assertTrue(actualProduct.getPrice() == 5);
//        assertTrue(actualProduct.getCategory() == "shoes");
//        assertTrue(actualProduct.getQuantity() == 1);
//        assertTrue(actualProduct.getSizes() == "2");
//
//        assertTrue(productManager.createProduct("shoe", "9999", -5.0, "shoes",0) == null);
//    }


    @Test
    public void decreaseQuantityBasic() throws Exception {
        Product product = productUseCaseCreate.saveNewProduct("shoe", "1", 5.0, "shoes",2);
        productUseCaseGet.decreaseQuantity(product, 1);
        assertEquals(1, product.getQuantity());
    }

    @Test
    public void decreaseQuantityBasic2() throws Exception {
        Product product = productUseCaseCreate.saveNewProduct("shoe", "1", 5.0, "shoes",50);
        productUseCaseGet.decreaseQuantity(product, 26);
        assertEquals(24, product.getQuantity());
    }

    @Test
    public void decreaseQuantityNegative() throws Exception {
        Product product = productUseCaseCreate.saveNewProduct("shoe383847828", "1", 5.0, "shoes",2);
        productUseCaseGet.decreaseQuantity(product, -50);
//        Product prod2 =  getProductGateway.getProduct("1");
//        String check = "" + product;
        assertEquals(2, product.getQuantity());
    }

    @Test
    public void decreaseQuantityZero() throws Exception {
        Product product = productUseCaseCreate.saveNewProduct("shoe", "1", 5.0, "shoes",2);
        productUseCaseGet.decreaseQuantity(product, 0);
        assertEquals(2, product.getQuantity());
    }

//    @Test
//    public void decreaseQuantityProductDoesNotExiist() throws Exception {
//        assertFalse(productUseCaseGet.decreaseQuantity("asdkjshdkjhafj", 1));
//    }


    @Test
    public void increaseQuantityBasic() throws Exception {
        Product product = productUseCaseCreate.saveNewProduct("shoe", "1", 5.0, "shoes",2);
        productUseCaseGet.increaseQuantity(product, 1);
        assertEquals(3, product.getQuantity());
    }

    @Test
    public void increaseQuantityBasic2() throws Exception {
        Product product = productUseCaseCreate.saveNewProduct("shoe", "1", 5.0, "shoes",2);
        productUseCaseGet.increaseQuantity(product, 51);
        assertEquals(53, product.getQuantity());
    }

    @Test
    public void increaseQuantityNegative() throws Exception {
        Product product = productUseCaseCreate.saveNewProduct("shoe", "1", 5.0, "shoes",2);
        productUseCaseGet.increaseQuantity(product, -50);
        assertEquals(2, product.getQuantity());
    }

    @Test
    public void increaseQuantityZero() throws Exception {
        Product product = productUseCaseCreate.saveNewProduct("shoe", "1", 5.0, "shoes",2);
        productUseCaseGet.increaseQuantity(product, 0);
        assertEquals(2, product.getQuantity());
    }

//    @Test
//    public void increaseQuantityProductDoesNotExiist() throws Exception {
//        assertFalse(productUseCaseGet.increaseQuantity("hretghghfdgnvfdgds", 5));
//    }



}
