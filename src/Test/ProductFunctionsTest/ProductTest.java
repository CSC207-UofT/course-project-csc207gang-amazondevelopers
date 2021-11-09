package ProductFunctionsTest;

import ProductFunctions.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    Product product;
    String name;
    String id;
    Double price;
    String category;
    String sizes;
    int quantity;

    @BeforeEach
    void setUp(){
        name = new String("test1");
        id = new String("0");
        price = 1.0;
        category = new String("test");
        sizes = new String("0");
        quantity = 1;

        product = new Product(name, id, price, category, sizes, quantity);
    }
    @Test
    void testToString(){;}
    @Test
    void testGetters(){;}
    @Test
    void testSetters(){;}
}
