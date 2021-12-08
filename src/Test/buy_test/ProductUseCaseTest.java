package buy_test;

import org.junit.Test;
import product.Product;
import options.buy.ProductUseCase;

import static org.junit.Assert.*;

public class ProductUseCaseTest {
    @Test
    public void testQuantityZero(){
        Product product = new Product("user","TEST",10.0,"TEST",0);
        ProductUseCase productUseCase = new ProductUseCase();
        assertFalse(productUseCase.productBuy(product));
    }
    @Test
    public void testRegularQuantity(){
        Product product = new Product("user","TEST",10.0,"TEST",1);
        ProductUseCase productUseCase = new ProductUseCase();
        assertTrue(productUseCase.productBuy(product));
    }
}
