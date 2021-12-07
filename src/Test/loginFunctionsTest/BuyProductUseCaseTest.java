package loginFunctionsTest;

import options.buy.ProductUseCase;
import org.junit.Test;
import product.Product;
import static org.junit.Assert.*;

public class BuyProductUseCaseTest {
    ProductUseCase productUseCase = new ProductUseCase();
    // String name, String id, Double price, String category, int quantity
    @Test
    public void productBuyTest(){
        Product product = new Product("test", "TEST", 5.0, "test", 1);
        productUseCase.productBuy(product);
        assertEquals(0, product.getQuantity());
    }
}
