package product_test;

import org.junit.Test;
import product.*;

import java.util.ArrayList;

import static org.junit.Assert.*;



public class ProductUseCaseTest {
    SaveProductGatewayInterface saveProductGatewayInterface = new SaveProductGateway();
    ProductUseCase productUseCase = new ProductUseCase(saveProductGatewayInterface);
    GetProductGateway getProductGateway = new GetProductGateway();

    Product testingProduct;

    @Test
    public void createProductTest() {
        String name = "big boy";
        String id = "12345";
        String price = "10";
        String category = "amogus";
        String quantity = "2";
        ArrayList<String> testArray = new ArrayList<String>();
        testArray.add(name);
        testArray.add(price);
        testArray.add(category);
        testArray.add(quantity);
        testingProduct = productUseCase.createProduct(testArray, id);

        assertEquals("big boy", testingProduct.getName());
        assertEquals("12345", testingProduct.getId());
        assertEquals(10, testingProduct.getPrice(), 0);
        assertEquals("amogus", testingProduct.getCategory());
        assertEquals(2, testingProduct.getQuantity());
    }


}
