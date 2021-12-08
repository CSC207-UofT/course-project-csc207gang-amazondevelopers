package product_test;

import delete_gateways.DeleteProductsGateway;
import product.GetProductGateway;
import product.Product;
import org.junit.Test;
import product.SaveProductGateway;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GetProductGatewayTest {
    Product testProduct = new Product("shoes", "lol", 5.0, "shoes", "medium",1);
    SaveProductGateway saveProductGateway = new SaveProductGateway();
    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
    GetProductGateway getProductGateway = new GetProductGateway();

    @Test
    public void getProductTest() {
        saveProductGateway.addProductToRepo(testProduct, testProduct.getId(), testProduct.getCategory());
        Product testingProduct = getProductGateway.getProduct(testProduct.getId());
        assertEquals("shoes", testingProduct.getName());
        assertEquals("lol", testingProduct.getId());
        assertEquals(5, testingProduct.getPrice(), 0);
        assertEquals("shoes", testingProduct.getCategory());
        assertEquals("medium", testingProduct.getSizes());
        assertEquals(1, testingProduct.getQuantity());
    }

    @Test
    public void getHashMapTest() {
        HashMap<String, Object> testHash = getProductGateway.getHashMap();
        assertEquals("java.util.HashMap", testHash.getClass().getName());
    }




}
